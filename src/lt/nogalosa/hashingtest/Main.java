package lt.nogalosa.hashingtest;

public class Main {

    public static void main(String[] args) {
        String toHash = "laba diiena ";

        NerHash nerHash = new NerHash(toHash);

        System.out.println(nerHash.hash());
    }

}
