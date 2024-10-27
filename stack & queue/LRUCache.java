import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Node head, tail;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy head and tail nodes to simplify insert and remove operations
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            // Move access node to the front (most recently used)
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If key exists, remove old node
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            // Remove least recently used node (node before tail)
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        // Remove node from linked list and map
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String args[]) {
        LRUCache cache = new LRUCache(2); // Cache capacity is 2

        cache.put(1, 1); // Cache is {1=1}
        cache.put(2, 2); // Cache is {2=2, 1=1}
        System.out.println(cache.get(1)); // Returns 1 and moves key 1 to front, making cache {1=1, 2=2}
        cache.put(3, 3); // Removes key 2 (least recently used), Cache becomes {3=3, 1=1}
        System.out.println(cache.get(2)); // Returns -1 (key 2 was removed)
        cache.put(4, 4); // Removes key 1, Cache becomes {4=4, 3=3}
        System.out.println(cache.get(1)); // Returns -1 (key 1 was removed)
        System.out.println(cache.get(3)); // Returns 3
        System.out.println(cache.get(4)); // Returns 4
    }
}