package lt.nogalosa.hashingtest;

public class NerHash {

    private String toHash;
    private final String[] picks = {
            "EomOqHYz86",
            "tAZ0vSB9ay",
            "iyXroMFEKm",
            "BIVvnFrLKs",
            "GvSxp9MdDI",
            "jud4cr7YUI",
            "BSWI47Ne9S",
            "F1r5VfhUgQ",
            "ESGVpQgQxI",
            "O0HRk7f6aR",
    };

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

        char[] sumCharList = (sum + "").toCharArray();

        String hash = "";

        int currentIndex = 0;
        int currentPickIndex = 0;
        for(int i = 0; i < 64; i++){
            if(currentIndex >= sumCharList.length)
                currentIndex = 0;
            if(currentPickIndex >= picks.length)
                currentPickIndex = currentPickIndex % picks.length;

            int currentValue = Character.getNumericValue(sumCharList[currentIndex]);
            hash += picks[currentPickIndex].charAt(currentValue);

            currentPickIndex += currentValue^2 + 1;
            currentIndex++;
        }

        return hash;
    }
}
