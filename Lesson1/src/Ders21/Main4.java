import java.util.PriorityQueue;
import java.util.Collections;

public class Main4 {
    public static void main(String[] args) {
        int[] ability = { 2, 1, 5, 3, 1};
        long processes = 17;
        int result = minimumTime(ability, processes);
        System.out.println(result); // Expected output: 9
    }

    public static int minimumTime(int[] ability, long processes) {
        // Max-Heap to manage processor abilities
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all abilities to the max-heap
        for (int a : ability) {
            maxHeap.add(a);
        }

        int seconds = 0;

        while (processes > 0) {
            // If the heap is empty, no more processors are available
            if (maxHeap.isEmpty()) {
                throw new IllegalStateException("Not enough processors to handle all processes");
            }

            // Get the processor with the maximum ability
            int maxAbility = maxHeap.poll();

            // Use the processor to handle processes
            processes -= maxAbility;

            // Update the processor's ability and add it back to the heap
            int updatedAbility = (int) Math.floor(maxAbility / 2.0);
            if (updatedAbility > 0) {
                maxHeap.add(updatedAbility);
            }

            seconds++;
        }

        return seconds;
    }
}
