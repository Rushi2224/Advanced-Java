package rushikapatel_sec001_a01;

public class method {

    public static void main(String[] args) {
        Double[] grades = {56.7, 89.23, 45.56, 88.40, 90.56};
        String[] product = {"iphone", "Galaxy", "Pixel", "Nokia"};
        Character[] status = {'y', 'n', 'i', 'd', 'e'};

        System.out.println("Version 1.0:");
        printArray(grades);
        printArray(product);
        printArray(status);

        System.out.println("\nVersion 2.0:");
        printArray(grades, 2);
        printArray(product, 1);
        printArray(status, 3);

        System.out.println("\nVersion 3.0:");
        printArray(grades, 1, 3);
        printArray(product, 0, 2);
        printArray(status, 1, 4);
    }

    // version 1.0
    public static <T> void printArray(T[] inputArray) {
        for (T element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // version 2.0
    public static <T> void printArray(T[] inputArray, int startIndex) {
        if (startIndex < 0 || startIndex >= inputArray.length) {
            System.out.println("Invalid startIndex.");
            return;
        }

        for (int i = startIndex; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }

    // version 3.0
    public static <T> void printArray(T[] inputArray, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0 || startIndex >= inputArray.length || endIndex >= inputArray.length || startIndex > endIndex) {
            System.out.println("Invalid indices.");
            return;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}
