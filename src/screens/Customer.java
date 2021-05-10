package screens;

import classes.Storage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Customer extends JFrame
{
    GridBagConstraints gbc;

    public Customer() {
        setTitle("Customer Screen");
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(1000, 500);

        JPanel jPanel = new JPanel();
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.BLACK);

        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
        setLayout(gbl);
        gbc = new GridBagConstraints();

        AddPanel (jPanel, 0, 7);
        AddPanel (jPanel2, 7, 3);


        GridBagLayout gbl2 = new GridBagLayout();
        gbl2.rowWeights = new double[] { 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1 };
        jPanel.setLayout(gbl2);

        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        AddPanel (jPanel, jPanel3, 0, 1, 0, 1);
        AddPanel (jPanel, jPanel4, 0, 1, 1, 9);
        jPanel3.setBackground(Color.BLUE);
        jPanel4.setBackground(Color.BLACK);

        JLabel fullName = new JLabel("Hi, " + Storage.currentCustomer.getName() + " " + Storage.currentCustomer.getSurname());
        fullName.setBorder(new EmptyBorder(0,0,10,0));
        jPanel3.add(fullName);

        int dieticianSize = Storage.getDieticians().size();
        JPanel dieticianList = new JPanel(new GridLayout(dieticianSize/3,3));
        jPanel3.add(dieticianList);
        dieticianList.add(new JButton("abc"));
        dieticianList.add(new JButton("abc"));

        JFrame frame = this;
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    new Main().setVisible(true);
                }
            }
        });
    }

    public void AddPanel(JPanel panel, int gridx, int gridwidth) {
        gbc.gridx = gridx;
        gbc.gridy = 0;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(panel, gbc);
    }

    public void AddPanel(JPanel rootPanel, JPanel panel, int gridx, int gridwidth, int gridy, int gridheight) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(panel, gbc);
    }
}
