class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }

        Queue<Integer> myQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) myQueue.offer(i);
        }

        int nodesVisited = 0;
        while (!myQueue.isEmpty()) {
            int course = myQueue.poll();
            nodesVisited++;

            for (int neighbor : adj.get(course)) {
                if (--indegrees[neighbor] == 0) myQueue.offer(neighbor);
            }
        }

        return nodesVisited == numCourses;
    }
}