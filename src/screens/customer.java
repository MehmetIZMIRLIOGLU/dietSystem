package screens;

import javax.swing.*;

public class customer extends JFrame
{
    public customer()
    {
        setTitle("Customer Screen");
        setSize(250,250);
        setLocationRelativeTo(null);

        JFrame frame = this;
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    new main().setVisible(true);
                }
            }
        });
    }
}