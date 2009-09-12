/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticimage.ui;

import geneticimage.NodeFunctionLibrarySettings;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author Calvin Ashmore
 */
public class FunctaionLibraryDialog extends JDialog {

    private List<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

    public FunctaionLibraryDialog() {

        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel, BorderLayout.CENTER);

        addCheckboxes(mainPanel);

        JPanel buttonPanel = new JPanel();
        final JButton ok = new JButton("OK");
        final JButton cancel = new JButton("cancel");

        buttonPanel.add(ok);
        buttonPanel.add(cancel);
        add(buttonPanel, BorderLayout.SOUTH);

        ActionListener listener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancel) {
                    setVisible(false);
                    dispose();
                } else if (e.getSource() == ok) {
                    apply();
                    setVisible(false);
                    dispose();
                }
            }
        };

        ok.addActionListener(listener);
        cancel.addActionListener(listener);

        setModal(true);
    }

    private void apply() {
        for (JCheckBox checkBox : checkBoxes) {
            String group = checkBox.getText();

            float weight = 0;
            if (checkBox.isSelected()) {
                weight = 1;
            }

            NodeFunctionLibrarySettings.getInstance().setWeight(group, weight);
        }
    }

    private void addCheckboxes(JPanel mainPanel) {
        for (String group : NodeFunctionLibrarySettings.getInstance().getGroupNames()) {
            JCheckBox checkBox = new JCheckBox(group);
            checkBoxes.add(checkBox);

            if (NodeFunctionLibrarySettings.getInstance().getWeight(group) > 0) {
                checkBox.setSelected(true);
            } else {
                checkBox.setSelected(false);
            }
            mainPanel.add(checkBox);
        }
    }
}
