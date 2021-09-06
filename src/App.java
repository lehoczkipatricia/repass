import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        personData();
        //Fejrész kiírása
        System.out.println("Jelszavak");
        //Verzió kiírása
        System.out.println("Verzió: 0.0.2");
        
        //A get objektummal kérhetünk be a konzolról
        Scanner input = new Scanner(System.in);

        System.out.print("Felhasználónév: ");
        String name = input.nextLine();
        // A password változó tárolja a jelszót
        System.out.print("Jelszó: ");
        String password = input.nextLine();
        System.out.print("Hely: ");
        String place = input.nextLine();
        input.close();
        int success = 0;
        try {
            /* 
            A jelszó, a felhasználónév és a 
            használati helye a passStore 
            objektumban van tárolva            
            */
            Store passStore = new Store(name, password, place);
            FileWriter fileWriter = new FileWriter("passwords.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(passStore.user);
            if(!passStore.hollow()) { printWriter.print(passStore.retrieval()); }
            printWriter.print(passStore.place);
            printWriter.close();
            success = 1;
        } catch (IOException e) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        if(success == 1) { System.out.println("Ok. A kiírás sikeres.");  }else {  System.out.println("Hiba! A kiírás sikertelen"); }

    }

    private static void personData() {
        System.out.println("Nagy János");
    }

}
