package dcll.Cherfa.WikiPars;

import java.util.regex.Pattern;

import org.tsaap.quesions.impl.DefaultAnswerBlock;
import org.tsaap.quesions.impl.DefaultQuiz;
import org.tsaap.quesions.impl.DefaultUserAnswerBlock;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.Quiz;


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
	 * @throws BadSyntaxException
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


}
