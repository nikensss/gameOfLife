class MessageNotifier extends Thread {

    // write fields to store variables here
    private final String msg;
    private final int repeats;

    public MessageNotifier(String msg, int repeats) {
        // implement the constructor
        this.msg = msg;
        this.repeats = repeats;
    }

    @Override
    public void run() {
        // implement the method to print the message stored in a field
        System.out.println((msg + "\n").repeat(repeats));
    }
}