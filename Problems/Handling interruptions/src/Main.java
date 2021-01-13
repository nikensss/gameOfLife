class CounterThread extends Thread {

    private long counter = 0;

    @Override
    public void run() {
        while (!isInterrupted()) {
            counter++;
        }
        System.out.println("It was interrupted");
    }
}