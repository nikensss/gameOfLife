class Invoker {

    public static void invokeMethods(Thread t1, Thread t2, Thread t3) throws InterruptedException {
        // start passed instances here
        waitFor(t3);
        waitFor(t2);
        waitFor(t1);
    }

    private static void waitFor(Thread t) throws InterruptedException {
        t.start();
        t.join();
    }
}