class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node prev;
        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> myMap;
    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        myMap = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!myMap.containsKey(key)) return -1;
        Node node = myMap.get(key);
        removeNode(node);
        insertNodeAtFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (myMap.containsKey(key)) {
            removeNode(myMap.get(key));
        }

        Node newNode = new Node(key, value);
        myMap.put(key, newNode);
        insertNodeAtFront(newNode);

        if (myMap.size() > capacity) {
            Node lru = tail.prev;
            removeNode(lru);
            myMap.remove(lru.key);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNodeAtFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */