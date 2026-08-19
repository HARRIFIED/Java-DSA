public class DosageCheck {
    public boolean isApprovedPackSize(long sample) {
        // base case => when we hit the approved base unit which is one we stop
        /*
            is(3/3) == is(1) => true
            is(27/3) => is(9/3) => is(3/3) => is(1) => true
            is(4/3) => is(1.333/3) => is(0.433) => false
            is(45/3) => is(15/3) => is(5) => is(1.66) => is(0.555) => false
        */
       System.out.println("isApprovedPackSize(" + sample + ")");
        if (sample == 1) {
            return true;
        }

        if (sample < 1 || sample % 3 != 0) {
            return false;
        }
        
        return isApprovedPackSize(sample / 3);
    }
}