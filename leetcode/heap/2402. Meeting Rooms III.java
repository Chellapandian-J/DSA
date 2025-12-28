import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            freeRooms.offer(i);
        }

        PriorityQueue<long[]> busyRooms =
                new PriorityQueue<>((a, b) -> {
                    if (a[0] == b[0]) return (int)(a[1] - b[1]);
                    return (int)(a[0] - b[0]);
                });

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long end = meeting[1];
            long duration = end - start;

            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.offer((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                busyRooms.offer(new long[]{end, room});
                count[room]++;
            }
            else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                busyRooms.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[result]) {
                result = i;
            }
        }

        return result;
    }
}
