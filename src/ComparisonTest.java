import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ComparisonTest {
    private static int factor = 1;
    private static int testSize = 10 * factor;

    public static void main(String[] args) {

        testMaxHeapN();
        testMaxHeapNLogN();

    }

    private static void testMaxHeapNLogN() {
        Integer[][] data = {
            {1,2,3,4,5,6,7,8,9,10},
            {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20},
            {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29,30},
            {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29,30
             ,31,32,33,34,35,36,37,38,39,40},
            {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29,30
             ,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}
        };
        for (Integer[] datum : data) {
            MaxHeap heap = new MaxHeap(datum.length);
            long startTime = System.nanoTime();

            heap.MaxHeapNLogN(datum);

            long endTime = System.nanoTime();
            System.out.println("heap creating time for MaxHeapNLogN for size " + datum.length + " : " + (endTime - startTime));

        }
    }

    private static void testMaxHeapN() {
        Integer[][] data = {
                {1,2,3,4,5,6,7,8,9,10},
                {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20},
                {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29,30},
                {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29,30
                ,31,32,33,34,35,36,37,38,39,40},
                {1,2,3,4,5,6,7,8,9,10, 11,12,13,14,15,16,17,18,19,20, 21,22,23,24,25,26,27,28,29,30
                ,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50}
        };
        for(Integer[] datum : data) {

            MaxHeap heap = new MaxHeap(datum.length);

            long startTime = System.nanoTime();

            heap.MaxHeapN(datum);

            long endTime = System.nanoTime();
            System.out.println("heap creating time for MaxHeapN for size " + datum.length + " : " + (endTime - startTime));
        }
    }
}
