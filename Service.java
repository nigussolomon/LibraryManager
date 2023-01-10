import java.io.Serializable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Service implements Serializable {
    static File credentials = new File("credentials.obj");
    private static ArrayList<User> users = new ArrayList<>();

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
}
