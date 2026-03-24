
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];
            adj.get(pre).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order[index++] = node;
            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        if (index == numCourses) {
            return order;
        }
        return new int[0];
    }
}
/*
leetcode link: https://leetcode.com/problems/course-schedule-ii/
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]

Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses-1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All prerequisite pairs are distinct.

time complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
space complexity: O(V + E) for the adjacency list and indegree array
*/