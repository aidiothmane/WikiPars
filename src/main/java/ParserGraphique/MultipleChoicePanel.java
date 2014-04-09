package ParserGraphique;

import java.util.ArrayList;
import java.util.List;

import org.tsaap.questions.Answer;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.Question;

import ParserGraphiqueModel.CheckBoxAnswer;



/**
 * @author Cherfa
 */
@SuppressWarnings("serial")
public class MultipleChoicePanel extends QuestionJPanel {

    /**
     * a CheckBoxAnswer list.
     */
    private List<CheckBoxAnswer> checkboxList =
            new ArrayList<CheckBoxAnswer>();
    /**
     * constructor with an answer.
     * @param question the question to set
     */
    public MultipleChoicePanel(final Question question) {
        super(question);
        for (AnswerBlock answerBlock : getQuestion().getAnswerBlockList()) {
            for (Answer ans : answerBlock.getAnswerList()) {
                CheckBoxAnswer checkbox = new CheckBoxAnswer(ans);
                add(checkbox);
                checkboxList.add(checkbox);
            }
        }
    }

    @Override
    public final float compute() {
        float credit = 0;
        for (CheckBoxAnswer ans : checkboxList) {
            float creditans = ans.getCorrection();
            if (ans.isSelected()) {
                credit += creditans;
            }
        }
        return credit;
    }

    @Override
    public final void reset() {
        for (CheckBoxAnswer ans : checkboxList) {
            ans.resetCorrection();
        }
    }

}
