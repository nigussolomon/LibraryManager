import javax.swing.*;

public class Base {
    JFrame regFrame = new JFrame();
    JFrame loginFrame = new JFrame();
    JTextField userField;
    JPasswordField passField;
    JButton login;
    JButton reg;

    public static void init(Integer width, Integer height, JFrame frame) {
        frame.setTitle("Ethio Library");
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addComp(JComponent[] components, JFrame frame) {
        for (JComponent comp : components) {
            frame.add(comp);
        }
    }
}

class Starter {
    public static void main(String[] args) {
        LoginFrame lg = new LoginFrame();
        lg.init();
    }
}
