import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Map<k, v> {
    ArrayList<MapNode<k, v>> buckets;
    int count;
    int numBuckets;

    public Map() {
        buckets = new ArrayList<>();
        numBuckets = 20;
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    private int getBucketIndex(k key) {
        int hc = key.hashCode();
        int index = hc % numBuckets;
        return index;
    }

    public void insert(k key, v value) {
        // Index where should node be placed accordig to given key
        int bucketIndex = getBucketIndex(key);
        // Node present at bucketindex
        MapNode<k, v> head = buckets.get(bucketIndex);

        // case1- already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // case 2&3- if null add newnode at bucket index
        // if not null new head is newnode and newnode added at bucketindex
        head = buckets.get(bucketIndex);
        MapNode<k, v> newNode = new MapNode<>(key, value);
        newNode.next = head;
        buckets.set(bucketIndex, newNode);

        // No of nodes increased by 1
        count++;
        double alpha = 1.0 * count / numBuckets;
        if (alpha >= 0.7) {
            reHash();
        }
    }

    private void reHash() {
        ArrayList<MapNode<k, v>> temp = buckets;
        buckets = new ArrayList<>();

        for (int i = 0; i < 2 * numBuckets; i++) {
            buckets.add(null);
        }

        count = 0;
        numBuckets = numBuckets * 2;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<k, v> head = temp.get(i);
            while (head != null) {
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public int size() {
        return count;
    }

    public v getValue(k key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<k, v> head = buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public v removeKey(k key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<k, v> head = buckets.get(bucketIndex);
        MapNode<k, v> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                // head is not the key
                if (prev != null) {
                    prev.next = head.next;
                }
                // head is the key itself,cant use prev as prev is itself null
                else {
                    buckets.set(bucketIndex, head.next);
                }
                count--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        // key not present at the bucketindex
        return null;
    }

    public double loadFactor() {
        return 1.0 * count / numBuckets;
    }

    // public static void main(String[] args) {
    // // cannot Create generic array
    // // Integer[] x = getArray(10);
    // // Map<Integer,Integer> m1 = new Map<>();
    // // m1.arr = new Node<Integer,Integer>[10];
    // }

    // // Generic array class
    // // public <T> T[] getArray(int size) {
    // // T[] genericArray = new T[size]; // suppose this is allowed
    // // return genericArray;
    // // }
}
