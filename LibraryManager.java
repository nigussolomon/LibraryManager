import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class LibraryManager extends Base {
    protected JFrame window = new JFrame();
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}

class Home extends LibraryManager implements ActionListener {
    private JButton logout;
    private JButton newBook;
    private JButton listBook;
    private JButton subBook;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane1;
    private JPanel new_panel;
    private JPanel panel1;
    private JTextField titleField;
    private JComboBox cb;
    private JComboBox cb1;
    private JTable jt;
    private JScrollPane sp;

    public void TABLE(JPanel panel) {
        jt = new JTable(new DefaultTableModel(new Object[] { "Title", "Category", "Status" }, 0));
        DefaultTableModel model = (DefaultTableModel) jt.getModel();
        if (Service.READ_BOOK_OBJ("books.obj") == null) {

        } else {
            for (Book obj : Service.READ_BOOK_OBJ("books.obj")) {
                model.addRow(new Object[] { obj.getTitle(), obj.getCategory(), obj.getStatus() });
            }
        }

        sp = new JScrollPane(jt);
        panel.add(sp);
    }

    public void init(String username) {
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

        listBook = new JButton("LIST BOOKS");
        listBook.setBounds(20, 60, 180, 35);
        listBook.setBackground(Color.DARK_GRAY);
        listBook.setForeground(Color.WHITE);
        listBook.setEnabled(false);
        listBook.addActionListener(this);

        newBook = new JButton("NEW BOOK");
        newBook.setBounds(210, 60, 180, 35);
        newBook.setBackground(Color.DARK_GRAY);
        newBook.setForeground(Color.WHITE);
        newBook.setEnabled(true);
        newBook.addActionListener(this);

        tabbedPane1 = new JTabbedPane();
        tabbedPane1.setBounds(20, 100, 735, 260);

        panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setAlignmentX(Component.LEFT_ALIGNMENT);

        TABLE(panel1);

        tabbedPane1.add("| BOOKS", panel1);

        tabbedPane2 = new JTabbedPane();
        tabbedPane2.setBounds(20, 400, 735, 125);

        JPanel panel1a = new JPanel();
        panel1a.setLayout(new BoxLayout(panel1a, BoxLayout.Y_AXIS));
        panel1a.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panel2a = new JPanel();
        panel2a.setLayout(new BoxLayout(panel2a, BoxLayout.Y_AXIS));
        panel2a.setAlignmentX(Component.LEFT_ALIGNMENT);

        tabbedPane2.add("| LIBRARY SCHEDULES", panel1a);
        tabbedPane2.add("| ALLOWED LOANS", panel2a);

        JLabel lib_schedule1 = new JLabel("MON - FRI,  8:30 AM - 9:00 PM");
        JLabel lib_schedule2 = new JLabel("SAT - SUN,  6:30 AM - 12:00 PM");
        JLabel lib_schedule3 = new JLabel("HOLIDAYS,  Library is closed!");
        lib_schedule3.setForeground(Color.RED);
        Font font3 = new Font("sans", Font.BOLD, 15);
        lib_schedule3.setFont(font3);

        panel1a.add(lib_schedule1);
        panel1a.add(lib_schedule2);
        panel1a.add(lib_schedule3);

        JLabel loan_rule_ug = new JLabel("UNDERGRADUATE  -  2 Books per loan every 3 weeks");
        JLabel loan_rule_pg = new JLabel("POSTGRADUATE  -  4 Books per loan every 3 weeks");
        JLabel loan_rule_in = new JLabel("INSTRUCTOR  -  No loan limit!");
        loan_rule_in.setForeground(Color.GREEN);
        Font font4 = new Font("sans", Font.BOLD, 15);
        loan_rule_in.setFont(font4);

        panel2a.add(loan_rule_ug);
        panel2a.add(loan_rule_pg);
        panel2a.add(loan_rule_in);

        new_panel = new JPanel();
        new_panel.setBounds(20, 100, 735, 350);
        new_panel.setLayout(new GridLayout(9, 0, 0, 1));

        JLabel titleLabel = new JLabel("TITLE");
        titleField = new JTextField();
        JLabel catLabel = new JLabel("CATEGORY");
        String cats[] = { "Programing", "Data Science", "Statistics" };
        cb = new JComboBox(cats);
        JLabel statLabel = new JLabel("STATUS");
        String stats[] = { "NEW", "USED", "ELECTRONIC" };
        cb1 = new JComboBox(stats);

        subBook = new JButton("SUBMIT");
        subBook.setBackground(Color.BLUE);
        subBook.setForeground(Color.WHITE);
        subBook.addActionListener(this);

        new_panel.add(titleLabel);
        new_panel.add(titleField);
        new_panel.add(catLabel);
        new_panel.add(cb);
        new_panel.add(statLabel);
        new_panel.add(cb1);
        new_panel.add(subBook);
        new_panel.setVisible(false);

        JComponent[] components = { activeUser, title, logout, newBook, listBook, tabbedPane1, tabbedPane2, new_panel };
        addComp(components, window);
        init(800, 600, window);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            window.setVisible(false);
            setUsername("");
            LoginFrame lg = new LoginFrame();
            lg.init();
        } else if (e.getSource() == newBook) {
            tabbedPane1.setVisible(false);
            tabbedPane2.setVisible(false);
            listBook.setEnabled(true);
            newBook.setEnabled(false);
            new_panel.setVisible(true);
        } else if (e.getSource() == listBook) {
            tabbedPane1.setVisible(true);
            tabbedPane2.setVisible(true);
            listBook.setEnabled(false);
            newBook.setEnabled(true);
            new_panel.setVisible(false);
        } else if (e.getSource() == subBook) {
            tabbedPane1.setVisible(true);
            tabbedPane2.setVisible(true);
            listBook.setEnabled(false);
            newBook.setEnabled(true);
            new_panel.setVisible(false);
            Book book = new Book();
            book.setTitle(titleField.getText());
            book.setCategory(cb.getSelectedItem().toString());
            book.setStatus(cb1.getSelectedItem().toString());
            Service.add_book(book);
            panel1.remove(sp);
            TABLE(panel1);
        }

    }

}
