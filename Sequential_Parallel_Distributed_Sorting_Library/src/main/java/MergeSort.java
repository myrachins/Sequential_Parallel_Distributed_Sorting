import java.util.ArrayList;
import java.util.List;

public final class MergeSort {
    public List<Integer> sortList(List<Integer> numbers) {
        if (numbers.size() <= 1) {
            return numbers;
        }
        int middle = numbers.size() / 2;
        List<Integer> leftPart = sortList(new ArrayList<Integer>(numbers.subList(0, middle)));
        List<Integer> rightPart = sortList(new ArrayList<Integer>(numbers.subList(middle, numbers.size())));

        return mergeLists(leftPart, rightPart);
    }

    public List<Integer> mergeLists(List<Integer> first, List<Integer> second) {
        int newSize = first.size() + second.size();
        int firstCounter = 0, secondCounter = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

        first.add(Integer.MAX_VALUE);
        second.add(Integer.MAX_VALUE);

        for (int i = 0; i < newSize; ++i) {
            if (first.get(firstCounter) < second.get(secondCounter)) {
                result.add(first.get(firstCounter++));
            } else {
                result.add(second.get(secondCounter++));
            }
        }

        return result;
    }
}
