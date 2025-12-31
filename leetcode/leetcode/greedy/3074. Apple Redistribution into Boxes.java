class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total=0;
        for(int a:apple){
            total+=a;
        }
        Arrays.sort(capacity);
        int boxes=0;
        int neededcapacity=0;
        for(int i=capacity.length-1;i>=0;i--){
            neededcapacity+=capacity[i];
            boxes++;
            if(neededcapacity>=total)return boxes; 
        }
        return boxes;
    }
}
//we can also use priority queue
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());
        for (int c : capacity) {
            pq.offer(c);
        }
        int usedCapacity = 0;
        int boxes = 0;
        while (!pq.isEmpty() && usedCapacity < totalApples) {
            usedCapacity += pq.poll();
            boxes++;
        }
        return boxes;
    }
}
