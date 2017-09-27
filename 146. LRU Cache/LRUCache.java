import java.util.HashMap;

class LRUCache {
    /**
     Double Linked List
     */
    private class Node {
        /**
         * Node Instance Variables
         */
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            // this.key used to trace back key of head.next in cache when delete head.next
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    /**
     * LRUCache Instance Variables
     */
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // Check if key is in map
        if (!cache.containsKey(key)) {
            return -1;
        }

        // Remove Current Node
        Node curr = cache.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // Move Current Node to the tail
        this.move_to_tail(curr);
        return curr.value;
    }

    public void put(int key, int value) {
        // Check if key-value pair is in map
        if (this.get(key) != -1) {
            cache.get(key).value = value;
            return;
        }
        // Check if map is full
        if (cache.size() == this.capacity) {
            // Remove head.next
            cache.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;

        }
        // Insert New Node to the tail.prev
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        this.move_to_tail(newNode);
      return;
    }

    private void move_to_tail(Node current) {
        tail.prev.next = current;
        current.prev = tail.prev;
        tail.prev = current;
        current.next = tail;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
