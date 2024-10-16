package rushikapatel_sec001_ex01;

public class Method {

    public static void main(String[] args) {
        // Sample arrays
        Double[] grades = {56.7, 89.23, 45.56, 88.40, 90.56};
        String[] products = {"iPhone", "Galaxy", "Pixel", "Nokia"};
        Character[] statuses = {'y', 'n', 'i', 'd', 'e'};

        // First Version: Print entire array
        System.out.println("First Version:");
        printArray(grades);
        printArray(products);
        printArray(statuses);

        // Second Version: Print from specified index to end
        System.out.println("\nSecond Version:");
        printArray(grades, 2);
        printArray(products, 1);
        printArray(statuses, 3);

        // Third Version: Print from start to end index
        System.out.println("\nThird Version:");
        printArray(grades, 1, 3);
        printArray(products, 2, 3);
        printArray(statuses, 2, 5);
    }

    // First Version: Print entire array
    public static <T> void printArray(T[] inputArray) {
        for (T element : inputArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Second Version: Print from specified index to end
    public static <T> void printArray(T[] inputArray, int startIndex) {
        if (startIndex < 0 || startIndex >= inputArray.length) {
            System.out.println("Improper startIndex.");
            return;
        }

        for (int i = startIndex; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }

    // Third Version: Print from start to end index
    public static <T> void printArray(T[] inputArray, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex < 0 || startIndex >= inputArray.length || endIndex >= inputArray.length || startIndex > endIndex) {
            System.out.println("Inproper indices.");
            return;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}
