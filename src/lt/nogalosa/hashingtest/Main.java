package lt.nogalosa.hashingtest;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String toHash = "Lietuva!";

        String fileName = "";
        if(args.length > 0)
            fileName = args[0];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Koki hash norite hashuoti?");
        System.out.println("1) Hashuoti \""+toHash+"\" (iš string)");
        System.out.println("2) Hashuoti is failo "+ (fileName!="" ? "("+fileName+")" : "(Negalima - failas nenurodytas)"));
        System.out.println("Kita...");
        System.out.println("3) Sugeneruoti a1000000.txt faila");


        String input = scanner.nextLine();
        int selection = 0;
        try {
            selection = Integer.parseInt(input);
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("");
        System.out.println("Pasirinkta " + selection + ".");
        System.out.println("");

        if(selection == 3) {
            System.out.println("Generuojama...");
            ArrayList<String> generated = new ArrayList<>();
            while(generated.size() < 1000000) {
                String string = generateString() + ", " + generateString();
                while(generated.contains(string))
                    string = generateString() + ", " + generateString();
                generated.add(string);
            }
            System.out.println("Irasoma...");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

                for(String string : generated)
                    writer.write(string + "\n");

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Baigta.");
        }else
        if(selection == 2) {
            try {
                File file = new File(fileName);
                Scanner sc = new Scanner(file);
                ArrayList<String> toHashes = new ArrayList<>();

                while(sc.hasNextLine()) {
                    toHash = sc.nextLine();
                    toHashes.add(toHash);
                }
                long time = 0;
                for(String str : toHashes) {
                    NerHash nerHash = new NerHash(str);
                    System.out.println(nerHash.hash());
                    time += nerHash.getTimeTaken()/1000;
                }
                System.out.println("Uztruko " + time + " μs(mikro) (" + time/1000 + " ms)");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            NerHash nerHash = new NerHash(toHash);
            System.out.println(nerHash.hash());
            System.out.println("");
            System.out.println("Užtruko " + nerHash.getTimeTaken()/1000 + " μs(mikro) (" + nerHash.getTimeTaken()/1000/1000 + " ms)");
        }

    }

    static Random random = new Random();

    public static String generateString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

}
