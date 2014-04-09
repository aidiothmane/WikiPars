package ParserGraphique;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

import org.tsaap.questions.Answer;
import org.tsaap.questions.AnswerBlock;
import org.tsaap.questions.Question;

import dcll.ctc.dcll.ctc.parser.gui.model.RadioButtonAnswer;

/**
 * @author Cherfa
 */
@SuppressWarnings("serial")
public class ExclusiveChoicePanel extends QuestionJPanel {
    /**
     * a ButtonGroup list.
     */
    private List<ButtonGroup> bgroupList = new ArrayList<ButtonGroup>();
    /**
     * a RadioButtonAnswer list.
     */
    private List<RadioButtonAnswer> radioList =
            new ArrayList<RadioButtonAnswer>();
    /**
     * constructor with an answer.
     * @param question the question to set
     */
    public ExclusiveChoicePanel(final Question question) {
        super(question);
        for (AnswerBlock answerBlock : getQuestion().getAnswerBlockList()) {
            ButtonGroup group = new ButtonGroup();
            bgroupList.add(group);
            for (Answer ans : answerBlock.getAnswerList()) {
                RadioButtonAnswer radioButton = new RadioButtonAnswer(ans);
                group.add(radioButton);
                radioList.add(radioButton);
                add(radioButton);
            }
        }
    }

    @Override
    public final float compute() {
        float credit = 0;
        for (RadioButtonAnswer ans : radioList) {
            float creditans = ans.getCorrection();
            if (ans.isSelected()) {
                credit += creditans;
            }
        }
        return credit;
    }
    @Override
    public final void reset() {
        for (ButtonGroup element : bgroupList) {
            element.clearSelection();
        }
        for (RadioButtonAnswer ans : radioList) {
            ans.resetCorrection();
        }
    }

}
