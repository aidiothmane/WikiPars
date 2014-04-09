package ParserGraphiqueModel;

import org.tsaap.questions.Answer;


public interface AnswerButton {

    /**
     * @return Answer the answer.
     */
    Answer getAnswer();
    /**
     * @param answer the Answer to set.
     */
    void setAnswer(Answer answer);
    /**
     * @return float the result of a question.
     */
    float getCorrection();
    /**
     * reset the answer of  question.
     */
    void resetCorrection();
}
