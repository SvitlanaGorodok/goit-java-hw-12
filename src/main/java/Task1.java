import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Task1 {
    private static final Object monitor = new Object();
    private static final ExecutorService service = Executors.newFixedThreadPool(1);
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long counter = 0;
        long startTime = System.nanoTime();
        FutureTask<String> task = new FutureTask<String>(() -> "Прошло 5 секунд");
        while(true){
            Thread.sleep(1000);
            counter++;
            System.out.println((System.nanoTime()-startTime)/1000000);
            if (counter%5 == 0){
                service.execute(task);
                System.out.println(task.get());
            }

        }

    }
}
