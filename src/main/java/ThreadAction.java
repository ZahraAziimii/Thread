import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAction {
    public void sumOfNumbersWithFixedThreapool(List<Integer> numbers) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        AtomicInteger sum = new AtomicInteger();
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        long startTime = System.currentTimeMillis();

        numbers.forEach(i -> executor.submit(() -> sum.addAndGet(i)));
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.NANOSECONDS);
        System.out.println("Fixed : " + sum.get());
    }

    public void sumOfNumbersCachedThreadpool(List<Integer> numbers) throws InterruptedException {
        ExecutorService excecutor = Executors.newCachedThreadPool();
        AtomicInteger sum = new AtomicInteger();
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        long startTime = System.currentTimeMillis();

        numbers.forEach(i -> excecutor.submit(() -> sum.addAndGet(i)));
        excecutor.shutdown();
        excecutor.awaitTermination(100, TimeUnit.NANOSECONDS);
        System.out.println("Cached : " + sum.get());
    }


    public void sumOfNumbersScheduledThreadpool(List<Integer> numbers) throws InterruptedException {
        ExecutorService executor = Executors.newScheduledThreadPool(100);
        AtomicInteger sum = new AtomicInteger();
        System.out.println(numbers.stream().reduce(0, Integer::sum));
        long startTime = System.currentTimeMillis();

        numbers.forEach(i -> executor.submit(() -> sum.addAndGet(i)));
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.NANOSECONDS);
        System.out.println("Scheduled : " + sum.get());


    }
}
