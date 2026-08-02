//challenge implement factorial given a number find its factorial. E.g 3! = 3 * 2 * 1 = 6
// note 0! = 1

public class Factorial {
    public int solution(int val) {
        //formular n! = n * (n - 1)!
        
        if (val == 0) {
            return 1;
        }
        return val * solution(val - 1);
    }
}