package lt.nogalosa.hashingtest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String toHash = "Lietuva!";

        String fileName = "";
        if(args.length > 0)
            fileName = args[0];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kokį hash norite hashuoti?");
        System.out.println("1) Hashuoti \""+toHash+"\" (iš string)");
        System.out.println("2) Hashuoti iš failo "+ (fileName!="" ? "("+fileName+")" : "(Negalima - failas nenurodytas)"));

        String input = scanner.nextLine();
        int selection = 0;
        try {
            if(Integer.parseInt(input) == 2){
                selection = 2;
            } else {
                selection = 1;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("Pasirinkta " + selection + ".");
        System.out.println("");

        if(selection == 2) {
            try {
                File file = new File(fileName);
                Scanner sc = new Scanner(file);

                toHash = sc.next();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        NerHash nerHash = new NerHash(toHash);
        System.out.println(nerHash.hash());
        System.out.println("");
        System.out.println("Užtruko " + nerHash.getTimeTaken()/1000 + " μs (" + nerHash.getTimeTaken()/1000/1000 + " ms)");
    }

}
