import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    
    public static String user;
    public static String pass;
    public static String place;
    public static int success;
    public static void main(String[] args) {
        aboutShow();
        getData();
        setData();
    }

    private static void aboutShow() {
        // Fejrész kiírása
        System.out.println("Jelszavak");
        // Verzió kiírása
        System.out.println("Verzió: 0.0.2");
        System.out.println("Nagy János");
    }

    public static void getData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Felhasználónév: ");
        user = input.nextLine();
        System.out.print("Jelszó: ");
        pass = input.nextLine();
        System.out.print("Hely: ");
        place = input.nextLine();
        input.close();
        success = 0;
    }

    public static void setData(){
        try {
            Profile profile = new Profile(user, pass, place);
            FileWriter fileWriter = new FileWriter("passwords.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(profile.user);
            if (!profile.isPassEmpty()) {
                printWriter.print(profile.getPass());
            }
            printWriter.print(profile.place);
            printWriter.close();
            success = 1;
        } catch (IOException e) {
            System.err.println(
                "Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        isPrintSuccessful();
    }

    public static void isPrintSuccessful(){
        if (success == 1) {
            System.out.println("Ok. A kiírás sikeres.");
        } else {
            System.out.println("Hiba! A kiírás sikertelen");
        }
    }
    

}
