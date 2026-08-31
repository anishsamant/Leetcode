class MedianFinder {

    PriorityQueue<Integer> lower;
    PriorityQueue<Integer> higher;

    public MedianFinder() {
        lower = new PriorityQueue<>((a,b) -> b - a);
        higher = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        lower.offer(num);
        higher.offer(lower.peek());
        lower.poll();

        if (lower.size() < higher.size()) {
            lower.offer(higher.peek());
            higher.poll();
        }
    }
    
    public double findMedian() {
        if (lower.size() > higher.size()) return lower.peek();

        return (lower.peek() + higher.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */