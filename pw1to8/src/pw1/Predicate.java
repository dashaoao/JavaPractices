package pw1;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}