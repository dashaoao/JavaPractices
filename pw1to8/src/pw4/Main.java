package pw4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) {
        Callable<String> task = () -> Thread.currentThread().getName();
        ExServ service = new ExServ(2);
        for (int i = 0; i < 7; i++) {
            Future<String> result = service.submit(task);
            try {
                System.out.println(result.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}