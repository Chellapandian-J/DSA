//brute force approach
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int m=points.length;
        int n=points[0].length;
        int p1=points[0][0];
        int p2=points[0][1];
        int count=0;
        for(int i=1;i<m;i++){
            int p3=points[i][0];
            int p4=points[i][1];
            while(p1!=p3 || p2!=p4){
                if(p1>p3)p1--;
                else if(p1==p3) p1=p3;
                else p1++;
                if(p2>p4)p2--;
                else if(p2==p4) p2=p4;
                else p2++;
                count++;
            }
            p1=p3;
            p2=p4;
        }
        return count;
    }
}
//optimal approach
//using Chebyshev distance
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time=0;
        for(int i=1;i<points.length;i++){
            int dx=Math.abs(points[i][0]-points[i-1][0]);
            int dy=Math.abs(points[i][1]-points[i-1][1]);
            time+=Math.max(dx,dy);
        }
        return time;
    }
}
/*On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.

You can move according to these rules:

In 1 second, you can either:
move vertically by one unit,
move horizontally by one unit, or
move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).
You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.
 
example 1:
Input: points = [[1,1],[3,4],[6,1]]
Output: 7
Explanation: One optimal path is shown below:
From [1,1] to [3,4] it takes 3 seconds (1 diagonal step to [2,2], then 1 diagonal step to [3,3], then 1 vertical step to [3,4]).
From [3,4] to [6,1] it takes 4 seconds (1 diagonal step to [4,3], then 1 diagonal step to [5,2], then 1 diagonal step to [6,1]).

example 2:
Input: points = [[3,2],[−2,2]]
Output: 5
Explanation: You can only move horizontally to visit all points.

time complexity: O(n)
space complexity: O(1)
/*