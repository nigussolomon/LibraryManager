import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryManager extends Base{
    protected JFrame window = new JFrame();
    private String username;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    
}

class Home extends LibraryManager implements ActionListener{
    private JButton logout;
    private JButton newBook;
    private JButton listBook;

    public void init(String username){
        setUsername(username);
        JLabel activeUser = new JLabel("LOGGED IN AS: @" + getUsername());
        activeUser.setBounds(20, 20, 250, 30);

        JLabel title = new JLabel("ETHIO LIBRARY");
        title.setBounds(550, 20, 350, 30);
        Font font = new Font("serif", Font.PLAIN, 30);
        title.setFont(font);

        logout = new JButton("LOGOUT");
        logout.setBounds(690, 535, 100, 30);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        logout.addActionListener(this);

        newBook = new JButton("NEW BOOK");
        newBook.setBounds(20, 60, 180, 35);
        newBook.setBackground(Color.GREEN);

        listBook = new JButton("LIST BOOKS");
        listBook.setBounds(230, 60, 180, 35);
        listBook.setBackground(Color.DARK_GRAY);
        listBook.setForeground(Color.WHITE);


        JComponent[] components = {activeUser, title, logout, newBook, listBook};
        addComp(components, window); 
        init(800, 600, window);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().getClass().getName());
        if (e.getSource() == logout) {
            window.setVisible(false);
            setUsername("");
            LoginFrame lg = new LoginFrame();
            lg.init();
        }
        
    }
    
}
