import java.util.Scanner;

class Matrix {
    int[][] matrix;
    int size;

    Matrix(int size) {
        this.size = size;
        matrix = new int[size][size];
    }

    void readMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}

class UniqueElementsRunnable implements Runnable {
    Matrix matrix;
    boolean isUnique = true;

    UniqueElementsRunnable(Matrix matrix) {
        this.matrix = matrix;
    }

    public void run() {
        boolean[] seen = new boolean[101]; // Assuming elements are between 0 and 100
        for (int[] row : matrix.matrix) {
            for (int elem : row) {
                if (seen[elem]) {
                    isUnique = false;
                    return;
                }
                seen[elem] = true;
            }
        }
    }
}

class RowSumRunnable implements Runnable {
    Matrix matrix;
    int[] rowSums;

    RowSumRunnable(Matrix matrix) {
        this.matrix = matrix;
        rowSums = new int[matrix.size];
    }

    public void run() {
        for (int i = 0; i < matrix.size; i++) {
            for (int j = 0; j < matrix.size; j++) {
                rowSums[i] += matrix.matrix[i][j];
            }
        }
    }
}

class ColumnSumRunnable implements Runnable {
    Matrix matrix;
    int[] columnSums;

    ColumnSumRunnable(Matrix matrix) {
        this.matrix = matrix;
        columnSums = new int[matrix.size];
    }

    public void run() {
        for (int j = 0; j < matrix.size; j++) {
            for (int i = 0; i < matrix.size; i++) {
                columnSums[j] += matrix.matrix[i][j];
            }
        }
    }
}

class PrincipalDiagonalSumRunnable implements Runnable {
    Matrix matrix;
    int principalDiagonalSum = 0;

    PrincipalDiagonalSumRunnable(Matrix matrix) {
        this.matrix = matrix;
    }

    public void run() {
        for (int i = 0; i < matrix.size; i++) {
            principalDiagonalSum += matrix.matrix[i][i];
        }
    }
}

class SecondaryDiagonalSumRunnable implements Runnable {
    Matrix matrix;
    int secondaryDiagonalSum = 0;

    SecondaryDiagonalSumRunnable(Matrix matrix) {
        this.matrix = matrix;
    }

    public void run() {
        for (int i = 0; i < matrix.size; i++) {
            secondaryDiagonalSum += matrix.matrix[i][matrix.size - 1 - i];
        }
    }
}

public class MagicSquareChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the square matrix: ");
        int size = scanner.nextInt();

        Matrix matrix = new Matrix(size);
        matrix.readMatrix();

        // Create runnable instances
        UniqueElementsRunnable uniqueRunnable = new UniqueElementsRunnable(matrix);
        RowSumRunnable rowSumRunnable = new RowSumRunnable(matrix);
        ColumnSumRunnable columnSumRunnable = new ColumnSumRunnable(matrix);
        PrincipalDiagonalSumRunnable principalDiagonalRunnable = new PrincipalDiagonalSumRunnable(matrix);
        SecondaryDiagonalSumRunnable secondaryDiagonalRunnable = new SecondaryDiagonalSumRunnable(matrix);

        // Create threads
        Thread uniqueThread = new Thread(uniqueRunnable);
        Thread rowSumThread = new Thread(rowSumRunnable);
        Thread columnSumThread = new Thread(columnSumRunnable);
        Thread principalDiagonalThread = new Thread(principalDiagonalRunnable);
        Thread secondaryDiagonalThread = new Thread(secondaryDiagonalRunnable);

        // Start threads
        uniqueThread.start();
        rowSumThread.start();
        columnSumThread.start();
        principalDiagonalThread.start();
        secondaryDiagonalThread.start();

        // Wait for all threads to finish
        try {
            uniqueThread.join();
            rowSumThread.join();
            columnSumThread.join();
            principalDiagonalThread.join();
            secondaryDiagonalThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieve results
        boolean isUnique = uniqueRunnable.isUnique;
        int[] rowSums = rowSumRunnable.rowSums;
        int[] columnSums = columnSumRunnable.columnSums;
        int principalDiagonalSum = principalDiagonalRunnable.principalDiagonalSum;
        int secondaryDiagonalSum = secondaryDiagonalRunnable.secondaryDiagonalSum;

        // Check if the matrix is a magic square
        boolean isMagicSquare = isUnique && (principalDiagonalSum == secondaryDiagonalSum);
        for (int i = 0; i < size; i++) {
            if (rowSums[i] != principalDiagonalSum || columnSums[i] != principalDiagonalSum) {
                isMagicSquare = false;
                break;
            }
        }

        // Display results
        System.out.println("Is the matrix a magic square? " + (isMagicSquare ? "Yes" : "No"));
    }
}
