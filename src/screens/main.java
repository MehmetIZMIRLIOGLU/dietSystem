package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame
{
    JButton dietician;
    JButton customer;

    public main()
    {
        setTitle("Main Screen");
        setSize(250,100);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));

        dietician = new JButton("Dietician");
        customer = new JButton("Customer");
        add(new JLabel("Select Type",SwingConstants.CENTER));
        JPanel pnl = new JPanel(new GridLayout(1,2));
        pnl.add(dietician);
        pnl.add(customer);
        add(pnl);

        dietician.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new dietician().setVisible(true);
            }
        });

        customer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
                new customer().setVisible(true);
            }
        });
    }
}
