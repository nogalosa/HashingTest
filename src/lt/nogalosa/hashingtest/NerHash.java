package lt.nogalosa.hashingtest;

public class NerHash {

    private String toHash;

    public NerHash(String toHash) {
        this.toHash = toHash;
    }

    public String getToHash() {
        return toHash;
    }

    public void setToHash(String toHash) {
        this.toHash = toHash;
    }

    public String hash() {
        char[] charList = toHash.toCharArray();

        long sum = 0;

        char lastChar = '.';
        for(char ch : charList){
            sum += lastChar & ~ch;
        }

        return sum+"";
    }
}
