package screens;

import classes.Genders;
import classes.Packages;
import classes.Storage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{
    JButton dietician;
    JButton customer;
    JFrame customerLoginFrame;

    public Main()
    {
        customerLoginFrame = customerLogin();
        setTitle("Main Screen");
        setSize(250,150);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));
        getRootPane().setBorder(new EmptyBorder(10,10,10,10));

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
                new Dietician().setVisible(true);
            }
        });

        customer.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                customerLoginFrame.setVisible(true);
            }
        });
    }

    private JFrame customerLogin()
    {
        JFrame customerRegisterFrame = customerRegister();
        JFrame frame = new JFrame();
        frame.setTitle("Customer Login");
        frame.setSize(250,150);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(3,1));
        frame.getRootPane().setBorder(new EmptyBorder(10,10,10,10));

        JComboBox<classes.Customer> customerJComboBox = new JComboBox<classes.Customer>();
        for(int i=0; i < Storage.getCustomers().size(); i++)
        {
            customerJComboBox.addItem(Storage.getCustomers().get(i));
        }
        frame.add(customerJComboBox);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        frame.add(loginBtn);
        frame.add(registerBtn);

        loginBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Storage.currentCustomer = (classes.Customer)customerJComboBox.getSelectedItem();
                frame.setVisible(false);
                dispose();
                new Customer().setVisible(true);
            }
        });

        registerBtn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                customerRegisterFrame.setVisible(true);
            }
        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.setVisible(false);
                setVisible(true);
            }
        });
        return frame;
    }

    private JFrame customerRegister()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Customer Register");
        frame.setSize(350,400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(9,2));
        frame.getRootPane().setBorder(new EmptyBorder(10,10,10,10));

        JLabel lblName = new JLabel("Name:");
        JLabel lblSurname = new JLabel("Surname:");
        JLabel lblBirthYear = new JLabel("Birth Year (ex.1990):");
        JLabel lblWeight = new JLabel("Weight (kg):");
        JLabel lblHeight = new JLabel("Height (cm):");
        JLabel lblGender = new JLabel("Gender:");
        JLabel lblPackage = new JLabel("Package:");
        JLabel lblAddress = new JLabel("Address:");

        JTextField fieldName = new JTextField();
        JTextField fieldSurname = new JTextField();
        JTextField fieldBirthYear = new JTextField();
        JTextField fieldWeight = new JTextField();
        JTextField fieldHeight = new JTextField();
        JComboBox<Genders> gendersJComboBox = new JComboBox<>(Genders.values());
        JComboBox<Packages> packagesJComboBox = new JComboBox<>(Packages.values());
        JTextField fieldAddress = new JTextField();

        frame.add(lblName);
        frame.add(fieldName);
        frame.add(lblSurname);
        frame.add(fieldSurname);
        frame.add(lblBirthYear);
        frame.add(fieldBirthYear);
        frame.add(lblWeight);
        frame.add(fieldWeight);
        frame.add(lblHeight);
        frame.add(fieldHeight);
        frame.add(lblGender);
        frame.add(gendersJComboBox);
        frame.add(lblPackage);
        frame.add(packagesJComboBox);
        frame.add(lblAddress);
        frame.add(fieldAddress);

        JButton btnCancel = new JButton("Cancel");
        JButton btnRegister = new JButton("Register");

        frame.add(btnCancel);
        frame.add(btnRegister);

        btnCancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.setVisible(false);
                customerLoginFrame.setVisible(true);
            }
        });

        btnRegister.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                classes.Customer newCustomer = new classes.Customer(fieldName.getText(),fieldSurname.getText(),Integer.parseInt(fieldBirthYear.getText()),Double.parseDouble(fieldWeight.getText()),Double.parseDouble(fieldHeight.getText()),(Genders) gendersJComboBox.getSelectedItem(),(Packages) packagesJComboBox.getSelectedItem(),fieldAddress.getText());
                Storage.addCustomer(newCustomer);
                Storage.currentCustomer = newCustomer;
                frame.setVisible(false);
                dispose();
                new Customer().setVisible(true);
            }
        });

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.setVisible(false);
                customerLoginFrame.setVisible(true);
            }
        });
        return frame;
    }
}
