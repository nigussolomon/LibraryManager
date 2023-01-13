import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("unchecked")

public class Service implements Serializable {
    static File credentials = new File("credentials.obj");
    static File booksFile = new File("books.obj");
    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Book> books = new ArrayList<>();

    public static void WriteObjectToFile(Object serObj, String file) {
        try {
            FileOutputStream fileOut = new FileOutputStream(file);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void RegisterService(User user) {
        if (credentials.exists() == false) {
            users.add(user);
            WriteObjectToFile(users, credentials.getName());
        } else {
            users = READ_CRED_OBJ(credentials.getName());
            users.add(user);
            WriteObjectToFile(users, credentials.getName());
        }
    }

    public static ArrayList<User> READ_CRED_OBJ(String filepath) {
        // does the same thing as the previous method but uses Register class as Type
        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<User> user = (ArrayList<User>) objectIn.readObject();
            objectIn.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Book> READ_BOOK_OBJ(String filepath) {

        try {
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Book> book = (ArrayList<Book>) objectIn.readObject();
            objectIn.close();
            return book;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static boolean auth(User user) {
        users = READ_CRED_OBJ(credentials.getName());
        boolean Success = false;
        for (User user_ : users) {
            if (user_.getUsername().equals(user.getUsername())) {
                if (Arrays.equals(user.getPassword(), user_.getPassword())) {
                    Success = true;
                }
            }
        }
        return Success;
    }

    public static void add_book(Book book) {
        if (booksFile.exists() == false) {
            books.add(book);
            WriteObjectToFile(books, booksFile.getName());
        } else {
            books = READ_BOOK_OBJ(booksFile.getName());
            books.add(book);
            WriteObjectToFile(books, booksFile.getName());
        }
    }
}
