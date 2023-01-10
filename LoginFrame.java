import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginFrame extends Base implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton login;
    private JButton reg;

    public void init() {
        JLabel title = new JLabel("LOGIN NOW");
        title.setBounds(20, 10, 350, 50);
        Font font = new Font("serif", Font.PLAIN, 30);
        title.setFont(font);

        JLabel userLabel = new JLabel("USERNAME");
        userLabel.setBounds(20, 60, 150, 30);
        this.userField = new JTextField();
        this.userField.setBounds(20, 90, 450, 30);

        JLabel passLabel = new JLabel("PASSWORD");
        passLabel.setBounds(20, 120, 150, 30);
        this.passField = new JPasswordField();
        this.passField.setBounds(20, 150, 450, 30);

        this.login = new JButton("LOGIN");
        this.login.setBounds(20, 200, 100, 30);

        JLabel or = new JLabel("OR");
        or.setBounds(130, 200, 150, 30);

        this.reg = new JButton("GO TO REGISTRATION");
        this.reg.setBounds(157, 200, 180, 30);
        this.reg.addActionListener(this);

        JComponent[] components = { title, userLabel, this.userField, passLabel, this.passField, this.login, or, this.reg };
        super.addComp(components, loginFrame);
        super.init(500, 280, loginFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reg) {
            super.loginFrame.setVisible(false);
            RegFrame rg = new RegFrame();
            rg.init();
        }

    }
}