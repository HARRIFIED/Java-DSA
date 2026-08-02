/* 
    challenge given a number (fibonacci step) return the value 
    example fibonacci(4) = 3
    0,1,1,2,3
*/

public class Fibonacci {
    public int solution(int step) {
        if (step < 2) {
            return step;
        }

        return solution(step - 1) + solution(step - 2);
    }
}
