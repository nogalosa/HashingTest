package lt.nogalosa.hashingtest;

public class NerHash {

    private String toHash;
    private final String[] picks = {
        "3t5pdcnkgk",
        "gnha9ym9hv",
        "qyfucdyett",
        "rnek4gmqkz",
        "eo23956bfq",
        "735a5rbpd9",
        "mbfwe40u6y",
        "03q6844can",
        "882g4mrg0d",
        "jvyq8cm3j6",
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

        int currentIndex = Character.getNumericValue(sumCharList[sumCharList.length-1]);
        int currentPickIndex = 0;

        for(int i = 0; i < 64; i++){
            if(currentPickIndex >= picks.length)
                currentPickIndex = currentPickIndex % picks.length;
            if(currentIndex >= sumCharList.length){
                currentIndex = 0;
                if(currentPickIndex == 0){
                    currentPickIndex = hash.length() % picks.length;
                }
            }

            int currentValue = Character.getNumericValue(sumCharList[currentIndex]);
            hash += picks[currentPickIndex].charAt(currentValue);

            currentPickIndex += currentValue^2;
            currentIndex++;
        }

        return hash;
    }
}
