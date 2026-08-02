/*
    challenge given a number return true if it can be splitable into clear halves until it gets to one. 
    Return false otherwise
 */ 

public class IsSplitable {
    public boolean isSplitOnlyBatch(long reading) {
        if (reading == 1) {
            return true;
        } else if (reading % 2 != 0 || reading < 1) {
            return false;
        }
        return isSplitOnlyBatch(reading / 2);
    }
}