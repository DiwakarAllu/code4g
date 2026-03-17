/**
Absolutely — let’s write your question **clearly, fully, and step by step**, so there’s no confusion.

---

# Clear Question Statement

Problem Name: Return Students to Original Position
Scenario:

* Jack is a sports teacher at St. Patrick’s School.
* He lines up **N students** in a row.
* Each student has a **jersey number from 1 to N**.
* At each position in the row, there is a **board with a unique number from 1 to N**.
* The **boards are fixed** and **cannot be moved**.

Game Rules:

1. Students initially stand in **increasing order of their jersey numbers**.
2. At every **beat of the drum**, **each student moves to the position indicated by the board at their current location**.

   * Example: If a student is at position 1 and the board there says 3, the student moves to position 3.
3. This continues **until all students return to their original positions**.

**Input:**

* Integer `N` → Number of students
* Array `B[ ]` of size `N` → Numbers on the boards at each position (permutation of 1..N)

**Output:**

* Integer → **Number of beats required for all students to return to their original positions**

---

### Example 1

**Input:**

```
N = 3
B = [1, 2, 3]
```

**Process:**

* Initial positions: students = [1,2,3], boards = [1,2,3]
* First beat:

  * Student 1 → position 1 (board = 1)
  * Student 2 → position 2 (board = 2)
  * Student 3 → position 3 (board = 3)
* All students are already at original positions

**Output:**

```
1
```

---

### 🔹 Example 2

**Input:**

```
N = 5
B = [2, 3, 1, 5, 4]
```

**Process:**

* Initial positions: students = [1,2,3,4,5], boards = [2,3,1,5,4]
* Track cycles:

  * Cycle 1: 1 → 2 → 3 → 1 → length 3
  * Cycle 2: 4 → 5 → 4 → length 2
* Number of beats = **LCM(3,2) = 6**

**Output:**

```
6
```

---

### Key Insight

* The board array represents a permutation
* Students move along cycles of this permutation
* Answer = LCM of all cycle lengths

*/


import java.util.*;

public class Main {

    // Helper: GCD
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Helper: LCM
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        int[] board = {2, 3, 1, 5, 4}; // input
        int n = board.length;

        boolean[] visited = new boolean[n];
        int ansLCM = 1; // For "return to original"
        int cycles = 0;  // For counting cycles / swaps

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int count = 0;
                int j = i;

                // Follow the cycle
                while (!visited[j]) {
                    visited[j] = true;
                    j = board[j] - 1; // -1 because array is 0-based
                    count++;
                }

                cycles++;          // Count this cycle
                ansLCM = lcm(ansLCM, count); // LCM of cycle lengths
            }
        }

        // Output variants
        System.out.println("Beats to return original = " + ansLCM);
        System.out.println("Number of cycles = " + cycles);
        System.out.println("Minimum swaps to sort = " + (n - cycles));
    }
}
