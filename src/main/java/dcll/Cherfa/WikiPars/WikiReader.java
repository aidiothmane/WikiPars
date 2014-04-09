package dcll.Cherfa.WikiPars;

import java.util.regex.Pattern;

import org.tsaap.quesions.impl.DefaultAnswer;
import org.tsaap.quesions.impl.DefaultAnswerBlock;
import org.tsaap.quesions.impl.DefaultQuestion;
import org.tsaap.quesions.impl.DefaultQuiz;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.QuestionType;
import org.tsaap.questions.Quiz;

/**
 * 
 * 
 * ------test comment-----**
 * 
 * */
public class WikiReader {
	private static final char CORRECT_ANSWER = '+';
	@SuppressWarnings("unused")
	private static final char BAD_ANSWER = '-';
	private static final String MULTIPLE_CHOICE = "[]";
	private static final String EXCLUSIVE_CHOICE = "()";
	private static final String QUESTION_TYPE_REG = "|type=\"";
	private static final String QUESTION_END_REG = "\"}\n";
	private static final String LINE_SEPARATOR = "\n";

	private String input = "";
	private Quiz quiz;

	/**
	 * This method parses the input and returns the generated quiz
	 * 
	 * @return Quiz
	 */
	public final Quiz parse() throws PasDEntrer, ErreurSyntax {
        if (input.isEmpty()) {
            throw new PasDEntrer("The Input is empty");
        }
        DefaultQuiz defQuiz = new DefaultQuiz();
        for (String str : splitQuestions()) {
            checkInputFormat(str);
            DefaultQuestion question = new DefaultQuestion();
            question.setTitle(getQuestionTitle(str));
            question.setQuestionType(getQuestionType(str));
            question.addAnswerBlock(getAnswerBlock(str));
            defQuiz.addQuestion(question);
        }
        quiz = defQuiz;
        return quiz;
    }
	/**
	 * This method return the quiz
	 * 
	 * @return Quiz
	 */
	public Quiz getQuiz() {
		return quiz;
	}

	/**
	 * This method set the input of the parser.
	 * 
	 * @param String
	 */
	public void setInput(String str) {
		this.input = str;
	}

	/**
	 * This method split the input to separate several questions
	 * 
	 * @return String array
	 */
	private String[] splitQuestions() {
		return input.split(LINE_SEPARATOR + LINE_SEPARATOR);
	}

	/**
	 * This method check the format of a input
	 * 
	 * @throws ErreurSyntax
	 */
	private void checkInputFormat(String input) throws ErreurSyntax {
		String answerFormat = "[\\+-] (\\w|\\p{Punct})+";
		Pattern pAnswer = Pattern.compile("\\}" + LINE_SEPARATOR + "("
				+ answerFormat + "" + LINE_SEPARATOR + ")*" + answerFormat,
				Pattern.DOTALL);
		Pattern pBraces = Pattern.compile("^\\{.*\\}", Pattern.DOTALL);
		Pattern ptype = Pattern.compile("\\|type=\"(\\(\\)|\\[\\])\"\\}");
		Pattern pQuestionText = Pattern.compile("\\{.+\\|", Pattern.DOTALL);

		if (!pBraces.matcher(input).find()) {
			throw new ErreurSyntax("Format error, braces missing");
		}
		if (!ptype.matcher(input).find()) {
			throw new ErreurSyntax("Format error, question type missing");
		}
		if (!pQuestionText.matcher(input).find()) {
			throw new ErreurSyntax("Format error, question text missing");
		}
		if (!pAnswer.matcher(input).find()) {
			throw new ErreurSyntax("Format error, invalid answers");
		}
		if (input.substring(input.indexOf("|type")).indexOf('+') < 0) {
			throw new ErreurSyntax("Format error, A good answer is missing");
		}
	}
	 /**
     * This method return the question type.
     * @param str a String
     * @return QuestionType
     */
    private QuestionType getQuestionType(final String str) {
        String type = str.substring(str.indexOf(QUESTION_TYPE_REG)
                + QUESTION_TYPE_REG.length(), str.indexOf(QUESTION_END_REG));
        if (type.equals(EXCLUSIVE_CHOICE)) {
            return QuestionType.ExclusiveChoice;
        } else if (type.equals(MULTIPLE_CHOICE)) {
            return QuestionType.MultipleChoice;
        } else {
            return QuestionType.Undefined;
        }
    }

    /**
     * This method return the title of the question.
     * @param str a String
     * @return String
     */
    private String getQuestionTitle(final String str) {
        return str.substring(1, str.indexOf(QUESTION_TYPE_REG));
    }

    /**
     * This method return the formatted AnswerBlock of the input.
     * @param str a String containing the questions
     * @return AnswerBlock
     */
    private AnswerBlock getAnswerBlock(final String str) {
        DefaultAnswerBlock answerBlock = new DefaultAnswerBlock();
        int correctAnswerNber = 0;

        String responseBlock = str.substring(
                str.indexOf(QUESTION_END_REG)
                + QUESTION_END_REG.length());
        String[] answersArray = responseBlock.split(LINE_SEPARATOR);

        for (String answer : answersArray) {
            if (answer.charAt(0) == CORRECT_ANSWER) {
                correctAnswerNber++;
            }
        }
        for (String answer : answersArray) {
            DefaultAnswer ans = new DefaultAnswer();
            ans.setTextValue(answer.substring(2));
            if (answer.charAt(0) == CORRECT_ANSWER) {
                ans.setPercentCredit(1.0f / correctAnswerNber);
            } else {
                ans.setPercentCredit(0f);
            }
            answerBlock.addAnswer(ans);
        }
        return answerBlock;
    }

}
