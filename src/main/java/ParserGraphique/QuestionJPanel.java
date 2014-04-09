package ParserGraphique;

import javax.swing.BorderFactory;

import org.tsaap.questions.Question;

/**
 * @author alpha oumar binta diallo
 */
@SuppressWarnings("serial")
public abstract class QuestionJPanel extends javax.swing.JPanel {

    /**
     * a question.
     */
    private Question question;

    /**
     * constructor with an answer.
     * @param input the question
     */
    public QuestionJPanel(final Question input) {
        this.question = input;
        this.setBorder(BorderFactory.createTitledBorder(input.getTitle()));
        this.setSize(getPreferredSize());
    }

    /**
     * this method return the question.
     * @return Question
     */
    protected final Question getQuestion() {
        return question;
    }

    /**
     * this method calculate the score made by the user.
     * @return float
     */
    public abstract float compute();

    /**
     * this method reset the Question panel.
     */
    public abstract void reset();
}
