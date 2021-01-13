class Predicate {

    public static final TernaryIntPredicate allValuesAreDifferentPredicate = (a, b, c) -> {
        return a != b && a != c && b != c;
    };

    @FunctionalInterface
    public interface TernaryIntPredicate {
        boolean test(int a, int b, int c);
    }

}