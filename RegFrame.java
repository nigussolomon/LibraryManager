import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RegFrame extends Base implements ActionListener {
    private JTextField userField;
    private JPasswordField passField;
    private JButton login;
    private JButton reg;

    public void init() {
        JLabel title = new JLabel("REGISTER NOW");
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

        this.reg = new JButton("REGISTER");
        this.reg.setBounds(20, 200, 100, 30);

        JLabel or = new JLabel("OR");
        or.setBounds(130, 200, 150, 30);

        this.login = new JButton("GO TO LOGIN");
        this.login.setBounds(157, 200, 150, 30);
        this.login.addActionListener(this);

        JComponent[] components = { title, userLabel, this.userField, passLabel, this.passField, this.login, or, this.reg };
        super.addComp(components, regFrame);
        super.init(500, 350, regFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            super.regFrame.setVisible(false);
            LoginFrame lg = new LoginFrame();
            lg.init();
        }

    }
}