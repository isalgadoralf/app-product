package soe.solid.crm.vista;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {
    private JTextField textField1;
    private JButton button1;

    public FrmPrincipal() throws HeadlessException {
        super("Mi primer ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        textField1 = new JTextField(20);
        button1 = new JButton("Aceptar");
        add(textField1);
        add(button1);
        setVisible(true);
    }
}
