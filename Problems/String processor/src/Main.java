import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        // implement this method
        while (true) {
            String string = scanner.nextLine();
            if (!hasLowerCaseCharacters(string)) {
                break;
            }
            System.out.println(string.toUpperCase());
        }
        System.out.println("FINISHED");
    }

    private boolean hasLowerCaseCharacters(String string) {
        return string.matches(".*[a-z]+.*");
    }
}