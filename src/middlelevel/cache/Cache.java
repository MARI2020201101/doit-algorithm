package middlelevel.cache;

import java.util.HashMap;
import java.util.Map;

class Cache {
    LinkedNode head;
    LinkedNode tail;
    int size;
    int currSize;
    Map<Integer, LinkedNode> cache = new HashMap<>();
    Cache(int size){
        this.size = size;
    }
    public String getCache(int key){
        LinkedNode node = cache.get(key);
        moveNodeToHead(node);
        return node.value;
    }
    public boolean removeCache(int key){
        LinkedNode node = cache.get(key);
        removeNode(node);
        cache.remove(key);
        return true;
    }
    public boolean putCache(int key, String value){
        ++currSize;
        if(currSize >= size){
            removeNodeFromTail(tail);
        }
        LinkedNode node = new LinkedNode(value);
        node.prev = tail;
        tail.next = node;
        tail = node;
        cache.put(key, node);
        return true;
    }
    private void moveNodeToHead(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        head.prev = node;
        node.next = head;
        head = node;
        node.prev = null;
    }
    private void removeNodeFromTail(LinkedNode node){
        LinkedNode nextTail = node.prev;
        nextTail.next = null;
        tail = nextTail;
    }
    private void removeNode(LinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
class LinkedNode{
    LinkedNode prev, next;
    String value;
    public LinkedNode(String value) {
        this.value = value;
    }
}