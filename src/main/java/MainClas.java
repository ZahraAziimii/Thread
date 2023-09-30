import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainClas {
    public static void main(String[] args) throws InterruptedException {
        ThreadAction threadAction = new ThreadAction();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            numbers.add(new Random().nextInt(1, 2));

        }
        threadAction.sumOfNumbersCachedThreadpool(numbers);
        threadAction.sumOfNumbersScheduledThreadpool(numbers);
        threadAction.sumOfNumbersWithFixedThreapool(numbers);
    }
}
