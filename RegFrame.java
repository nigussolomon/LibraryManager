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
        this.userField.setBounds(20, 90, 450, 40);

        JLabel passLabel = new JLabel("PASSWORD");
        passLabel.setBounds(20, 130, 150, 30);
        this.passField = new JPasswordField();
        this.passField.setBounds(20, 160, 450, 40);

        JCheckBox check = new JCheckBox("I have agreed to the Terms and Conditions.", true);
        check.setBounds(20, 200, 350, 30);

        this.reg = new JButton("REGISTER");
        this.reg.setBounds(20, 230, 100, 40);
        this.reg.addActionListener(this);

        JLabel or = new JLabel("OR");
        or.setBounds(130, 230, 150, 40);

        this.login = new JButton("GO TO LOGIN");
        this.login.setBounds(160, 230, 150, 40);
        this.login.addActionListener(this);

        JComponent[] components = { title, userLabel, this.userField, passLabel, this.passField, check ,this.login, or, this.reg };
        super.addComp(components, regFrame);
        super.init(500, 320, regFrame);
    }

    public void userObject(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            super.regFrame.setVisible(false);
            LoginFrame lg = new LoginFrame();
            lg.init();
        } else if (e.getSource() == this.reg){
            User user = new User();
            user.setUsername(userField.getText());
            user.setPassword(passField.getPassword());
            Service.RegisterService(user);
            JOptionPane.showMessageDialog(regFrame, "Succesfully Registered as @" + user.getUsername(), "Success", JOptionPane.INFORMATION_MESSAGE);
            super.regFrame.setVisible(false);
            LoginFrame lg = new LoginFrame();
            lg.init();
        }
    }
}