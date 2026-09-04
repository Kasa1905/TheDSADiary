class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// only need addToFront and Delete
class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    // initializ a <capacity> size data sctructure with two empty nodes pointing to each other (head and tail)
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    // move the current node to head, O(1)
    public void moveToHead(Node curr) {
        curr.next = head.next;
        curr.prev = head;
        head.next = curr;
        curr.next.prev = curr;
    }

    // delete the current node, O(1)
    public void delete(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    // when getting this node, delete it and move it to head because it is recently used, O(1)
    public int get(int key) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            delete(curr);
            moveToHead(curr);
            return curr.val;
        }
        return -1;
    }

    // puts a new node if it doesn't already exist. Regardless of if it already exists, this node is brough to head
    // because it is recently used. If capacity exceeds, remove the tail because it is the least used, O(1)
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node curr = map.get(key);
            curr.val = value;
            delete(curr);
            moveToHead(curr);
        }
        else if(map.size()<capacity) {
            map.put(key, new Node(key, value));
            moveToHead(map.get(key));
        }
        else {
            map.put(key, new Node(key, value));
            map.remove(tail.prev.key);
            delete(tail.prev);
            moveToHead(map.get(key));
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */