package pw5;


public class Main {
    public static void main(String[] args) {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s1e = Singleton1.getInstance();
        System.out.println(s1 + " " + s1e + " " + s1.equals(s1e));

        Singleton2 s2 = Singleton2.getInstance();
        Singleton2 s2e = Singleton2.getInstance();
        System.out.println(s2 + " " + s2e + " " + s2.equals(s2e));

        Singleton3 s3 = Singleton3.getInstance();
        Singleton3 s3e = Singleton3.getInstance();
        System.out.println(s3 + " " + s3e + " " + s3.equals(s3e));

    }
}