package recursion.famous_recursion_problems;

public class Hanoi {
    public static void main(String[] args) {
        // Solving Tower of Hanoi problem for 2 disks
        // 'S' is the source rod, 'T' is the temporary (helper) rod, 'D' is the destination rod
        move(3, 'S', 'T', 'D');
    }

    private static void move(int n, char S, char T, char D) {
        // Base case: If no disks to move, return
        if (n == 0)
            return;

        // Move n-1 disks from source (S) to helper (T) using destination (D) as auxiliary
        move(n - 1, S, D, T);

        // Move the nth (largest) disk directly from source (S) to destination (D)

        System.out.println("Move " + n + " from " + S + " to " + D);

        // Move the n-1 disks from helper (T) to destination (D) using source (S) as auxiliary
        move(n - 1, T, S, D);  // ✅ Corrected here
    }
}
