class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        List<Integer> coursesTaken = new ArrayList<>();
        while (!myQueue.isEmpty()) {
            int course = myQueue.poll();
            coursesTaken.add(course);

            for (int neighbor : adj.get(course)) {
                if (--indegrees[neighbor] == 0) myQueue.offer(neighbor);
            }
        }

        return coursesTaken.size() == numCourses ? coursesTaken.stream().mapToInt(Integer::intValue).toArray() : new int[]{};
    }
}