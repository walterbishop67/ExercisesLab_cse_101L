/**
 * @date 13.12.2022
 */

public class Exercise03 {


    public static void main(String[] args) {

        //Question 1
        /*int[][] array2D = generateArray2D(4, 4, 0, 10);
        display2D(array2D);
        int diagonalSum = sumDiagonal(array2D);
        System.out.println("Sum of the diagonal for the given 2D array is: " + diagonalSum);*/


        //Question 2
        /*int[][] employees = generateArray2D(8, 7, 4, 9);
        display2D(employees);
        int[] workingHours = employeeWorkingHours(employees);
        display2D(employees);
        display(workingHours);*/


        //Question 3
        /*int[][] matrixA = generateArray2D(3, 2, 1, 10);
        int[][] matrixB = generateArray2D(2, 3, 1, 10);
        display2D(matrixA);
        display2D(matrixB);

        int[][] productMatrix = dotProduct(matrixA, matrixB);
        display2D(productMatrix);*/


        //Question 4
        /*double[][] points = generateArray2D(12, 5, -0.3, 0.3);
        display2D(points);
        int[] closestPoints = getClosestPoints(points, 0);
        System.out.println("Indexes of points with closest distance");
        display(closestPoints);*/


        //Question 5
        /*char[][] charArray2D = headsNtails(0);
        display2D(charArray2D);*/


    }

    // Question 1: Sum the major diagonal in a matrix
    public static int sumDiagonal(int[][] array2D) {
        /*
         * Write a method that sums all the numbers in the major diagonal
         * in an n x n matrix
         *
         * Args:
         *      array2D (int[n][n]) : two dimensional array of integers
         *
         * Returns:
         *      (int) : sum of all the numbers in the major diagonal
         */

        int sum = 0;
        for (int i = 0, j = 3; i < array2D.length; i++, j--) {

            sum += array2D[i][i];
            sum += array2D[i][j];

        }

        return sum;
    }

    // Question 2: Compute the weekly hours for each employee
    public static int[] employeeWorkingHours(int[][] employees) {
        /*
         * Suppose the weekly hours for all employees are stored in a
         * two-dimensional array. Each row records an employee's seven
         * day work hours with seven columns. Write a method that sorts the
         * employee's according to their sum of working hours for an enteire week
         * in decreasing order. Finally returns the sum of working hours for each
         * employee (sort both returned array and given employees array)
         *
         * Args:
         *      employees (int[8][7]) : the array of employees. Each row contains
         *      the employee's seven day work hours.
         *
         * Returns:
         *      int[8] : the array of sum working hours for each employee in decreasing order.
         */

        int[] a = new int[employees.length];
        int[] sum = new int[employees.length];
        for (int i = 0; i < employees.length; i++) {
            for (int j = 0; j < employees[i].length; j++) {
                sum[i] += employees[i][j];
            }
        }

        for (int k = 0; k < sum.length; k++) {
            for (int b = 0; b < sum.length; b++) {
                if (sum[k] > sum[b]) {
                    int temp = sum[k];
                    sum[k] = sum[b];
                    sum[b] = temp;

                }
            }
        }

        return sum;
    }

    // Question 3: multiply two matrices
    public static int[][] dotProduct(int[][] matrixA, int[][] matrixB) {
        /*
         * Write a method to multiply two matrices.
         *
         * Args:
         *      matrixA (int[m][n]) : the two-dimensional array of integers
         *      matrixB (int[n][k]) : the two-dimensional array of integers
         *
         * Returns:
         *      int[m][k] : the two-dimensional array of result dot product of
         *      matrixA and matrixB
         */

        int[][] sum = new int[matrixA.length][matrixB[0].length];
        if (matrixA[0].length != matrixB.length)
            return sum;//this expression will return an empty array if the column of the matrix is not equal to the row of the matrix
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    sum[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return sum;
    }

    // Question 4: All closest pairs of points
    public static int[] getClosestPoints(double[][] points, int pointIndex) {
        /*
         * Write a method that returns the array indices of the closest points to the given
         * point index. if m number of points share the same minimum distance to
         * given point index, then your array will have all of those points
         *
         * Args:
         *      points (double[n][d]) : array of n points in d dimensional space
         *      pointIndex (int) : index of a point from points array that we will search for closest m points
         *
         * Returns:
         *      (int[m]) : array of point indices that share the same minimum distance to given point
         */
        double[] array = new double[points.length];
        double min = 99999;
        int count = 0;
        int[] array2 = new int[points.length];
        for(int i = 0; i < points.length; i++){
            array[i] = distance(points[i], points[pointIndex]);
            if(i != pointIndex){
                if(array[i] <= min){
                    min = array[i];
                }
            }
        }
        for(int j = 0; j < array.length; j++){
               if(pointIndex!= j){
                 if(array[j] == min) {
                    array2[count] = j;
                    count++;
                }
            }
        }
        int n = 0;
        int[] array3 = new int[count];
        for (int k = 0; k < array3.length; k++) {
            array3[n] = array2[k];
            if (array2[k] != 0) {
                n++;
            }
        }

        return array3;
    }

    // Calculates the euclidean distance between two points in d dimensional space
    public static double distance(double[] pointA, double[] pointB) {
        /*
         * Helper method for calculating distance between given two points
         *
         * Args:
         *      pointA (double[d]) : a point in d-dimensional space
         *      pointB (double[d]) : a point in d-dimensional space
         *
         * Returns:
         *      (double): distance between given two points UP TO 1 DECIMAL PLACE
         */

        double a = 0;
        double[] array = new double[pointA.length];
        for (int i = 0; i < pointB.length; i++){
            array[i] = Math.pow(pointA[i] - pointB[i],2);
            a += array[i];
        }

        return Math.sqrt(a);

    }

    // Question 5: Nine heads and tails
    public static char[][] headsNtails(int number) {
        /*
         * Nine coins are placed in a 3-by-3 matrix with some face up and
         * some face down. You can represent the state of the coins using a
         * 3-by-3 matrix with values 0 (heads) and 1 (tails). Here are some examples:
         *      0 0 0       1 0 1       1 0 0
         *   A: 0 1 0    B: 0 0 1   C:  1 1 1
         *      0 0 0       1 0 0       1 1 0
         *
         *  Each state can also be represented using a binary number: For example,
         *  the preceding A, B and C matrices correspond to the numbers
         *      A: 0 0 0 0 1 0 0 0 0
         *      B: 1 0 1 0 0 1 1 0 0
         *      C: 1 0 0 1 1 1 1 1 0
         *
         *  There are a total of 512 posibilities, so you can use
         *  decimal numbers 0, 1, 2, ..., 511 to represent all states of the matrix.
         *      for A: number == 10
         *      for B: number == 332
         *      for C: number == 318
         *
         * Write a program that accepts a number and returns the corresponding matrix with
         * the characters H and T
         *
         *      if the number == 7;
         *      then the binary of 7 == 0 0 0 0 0 0 1 1 1;
         *      so in matrix format it will be;
         *              0 0 0
         *              0 0 0
         *              1 1 1
         *
         *      finally we can represent it with coins like;
         *              H H H
         *              H H H
         *              T T T
         *
         * Args:
         *      number (int): the number to represent with the characters H and T in matrix format
         *
         * Returns:
         *      (char[3][3]): the corresponding matrix representation of given number with coins
         */
        char[][] b = new char[3][3];
        int[] c = decimalToBinary(number);
        int y = 0;
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b.length; j++){
                b[i][j] = 'H';
                if(c[y] != 0){
                    b[i][j] = 'T';
                }
                y++;
            }

        }
        return b;
    }

    // Converts the given decimal number to a binary represented with an array
    public static int[] decimalToBinary(int number) {
        /*
         * Helper method to conver the given decimal number to binary representation
         *
         * Args: number (int): the decimal number convert to binary
         * Returns: int[9]: the binary representation of the given number
         */

        int[] b = new int[9];
        int[] a = {256, 128, 64, 32, 16, 8, 4, 2, 1};
        for (int i = 0; i < a.length; i++) {

            if (number % a[i] != number) {
                number =  number % a[i];
                b[i] = 1;

            }
        }

        return b;
    }

    /////////////// HELPER METHODS ////////////////////////////

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void display(double[] array) {
        for (double i : array) {
            System.out.printf("%.1f\t", i);
        }
        System.out.println();
    }

    public static void display(int[] array) {
        for (int i : array) {
            System.out.printf("%d\t", i);
        }
        System.out.println();
    }

    public static void display(char[] array) {
        for (int i : array) {
            System.out.printf("%c\t", i);
        }
        System.out.println();
    }

    public static void display2D(int[][] array2D) {
        for (int[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static void display2D(double[][] array2D) {
        for (double[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static void display2D(char[][] array2D) {
        for (char[] row : array2D) {
            display(row);
        }
        System.out.println("--------------------------");
    }

    public static int[][] generateArray2D(int m, int n, int start, int end) {
        int[][] array2D = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = random(start, end);
            }
        }

        return array2D;
    }

    public static double[][] generateArray2D(int m, int n, double start, double end) {
        double[][] array2D = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2D[i][j] = round(random(start, end), 1);
            }
        }

        return array2D;
    }

    public static int random(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    public static double random(double start, double end) {
        return start + Math.random() * (end - start + 1);
    }

    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
