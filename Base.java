import javax.swing.*;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatIntelliJLaf;

public class Base {
    JFrame regFrame = new JFrame();
    JFrame loginFrame = new JFrame();

    public static void init(Integer width, Integer height, JFrame frame) {
        frame.setTitle("Ethio Library");
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addComp(JComponent[] components, JFrame frame) {
        for (JComponent comp : components) {
            frame.add(comp);
        }
    }

    public static void Theme(){
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize theme. Using fallback." );
        }
    }
}

class Starter {
    public static void main(String[] args) {
        Base.Theme();
        LoginFrame lg = new LoginFrame();
        lg.init();
    }
}
