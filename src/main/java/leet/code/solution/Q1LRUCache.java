package leet.code.solution;
import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * <p>
 * The functions get and put must each run in O(1) average time complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class Q1LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

//    private LinkedHashMap<Integer, Integer> map;
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        // accessOrder = true means access-order (LRU), not insertion-order
//        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > capacity;  // Remove oldest when exceeds capacity
//            }
//        };
//    }
//
//    public int get(int key) {
//        return map.getOrDefault(key, -1);  // Automatically updates access order
//    }
//
//    public void put(int key, int value) {
//        map.put(key, value);  // Automatically triggers removeEldestEntry if needed
//    }

    static class LRUCache {
        Map<Integer, Node> map;
        int capacity = 0;
        Node head;
        Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            Node head = null;
            Node tail = null;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(node);
                map.put(key, add(key, node.val));
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                remove(map.get(key));
            } else if (map.size() >= capacity) {
                map.remove(remove(tail));
            }
            map.put(key, add(key, value));
        }

        private Node add(int key, int val) {
            Node newNode = new Node(key, val, head);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                head.prev = newNode;
                head = newNode;
            }
            return newNode;
        }

        private int remove(Node node) {
            int key = node.key;
            if (node.next == null && node.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else if (node.next != null && node.prev == null) {
                head = head.next;
                head.prev = null;
            } else if (node.prev != null) {
                Node tempP = node.prev;
                Node tempN = node.next;
                tempP.next = tempN;
                tempN.prev = tempP;
            } else {
                head = null;
                tail = null;
            }
            return key;
        }

        static class Node {
            int key;
            int val;
            Node next;
            Node prev;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            Node(int key, int val, Node next) {
                this.key = key;
                this.val = val;
                this.next = next;
            }
        }
    }
}
