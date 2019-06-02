import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class MergeSortTest {
    private final Random random = new Random();

    @Test
    void testSort() {
        MergeSort sort = new MergeSort();

        for (int i = 1; i <= 1000; ++i) {
            List<Integer> numbers = generateRandomList(i);
            List<Integer> sorted = sort.sortList(numbers);
            Collections.sort(numbers);

            Assertions.assertEquals(sorted, numbers);
        }
    }

    private List<Integer> generateRandomList(int size) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < size; ++i) {
            numbers.add(random.nextInt());
        }

        return numbers;
    }
}
