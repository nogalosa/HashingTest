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
            sum += lastChar & ch; // AND
            sum += lastChar | ch; // OR
            sum += lastChar ^ ch; // XOR
            sum += ~ch; // NOT
            sum += lastChar & ch^2; // AND ^2
            sum += lastChar | ch^3; // OR ^3
            sum += lastChar ^ ch^4; // XOR ^4
            sum += ~ch^5; // NOT ^5
            sum = sum^2;
            lastChar = ch;
        }


        return sum+"";
    }
}
