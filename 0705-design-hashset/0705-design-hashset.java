class MyHashSet {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;
    private Node[] table;
    private int size;

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        table = new Node[DEFAULT_CAPACITY];
    }

    private int hash(int key) {
        return key % table.length;
    }

    public void add(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return; // Key already exists, no need to add
            }
            current = current.next;
        }

        // Key does not exist, add it to the beginning of the linked list
        Node newNode = new Node(key);
        newNode.next = table[index];
        table[index] = newNode;
        size++;

        // Check if rehashing is needed
        if (size > table.length * LOAD_FACTOR) {
            rehash();
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                // Key found, remove it
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return true; // Key found
            }
            current = current.next;
        }

        return false; // Key not found
    }

    private void rehash() {
        Node[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;

        for (Node current : oldTable) {
            while (current != null) {
                add(current.key);
                current = current.next;
            }
        }
    }
}