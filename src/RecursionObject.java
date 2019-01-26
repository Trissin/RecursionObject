public class RecursionObject {
    int ackermannCalled = 0; // integer to store # times ackermann function called

    public RecursionObject() {
    }

    public int recursiveOne(int limit) { // first recursive program

        if (limit == 1) { // first term is 3
            return 3;
        } else if (limit == 2) { // second term is 2
            return 2;
        } else { // nth term
            return 2 * recursiveOne(limit - 1) + recursiveOne(limit - 2); // 2*previous term + term n-2
        }
    }

    public int nonRecursiveTwo(int limit) { // non-recursive program
        int nValue = 4; // term 1 is 4
        for (int i = 0; i <= limit; i++) { // for loop which finds nth term
            nValue = 3 * nValue + 1; // computes the terms 1 by 1 until reaching desired term
        }
        return nValue;
    }

    public int recursiveThree(int m, int n) { // ackermann function
        ackermannCalled++; // every time this is called, add 1 to the count
        if (m == 0) { // if m is 0
            return n + 1; // return n + 1
        } else if (n == 0) { // if n is 0
            return recursiveThree(m - 1, 1); // call this method for m-1 and n
        } else { // otherwise
            return (recursiveThree(m - 1, recursiveThree(m, n - 1))); // call this function for m-1 and another variant of this function
        }
    }

    public int howManyTimesWasTheAckermannFunctionCalled() {
        return ackermannCalled;
    } // method that returns # of times the ackermann function was called
}
