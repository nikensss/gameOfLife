class Create {

    public static Runnable createRunnable(String text, int repeats) {
        return () -> System.out.println((text + "\n").repeat(repeats));
    }
}