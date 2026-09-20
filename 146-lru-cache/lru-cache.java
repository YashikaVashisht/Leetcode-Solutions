class LRUCache {
    class ListNode{
        int key;
        int value;
        ListNode prev;
        ListNode next;
        ListNode(int key , int value){
            this.key=key;
            this.value=value;
        }
    }

    HashMap<Integer, ListNode> hm;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        head= new ListNode(-1,-1);
        tail= new ListNode(-1,-1);
        this.capacity=capacity;
        hm= new HashMap<>();

        head.next=tail;
        tail.prev=head;

    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }

        ListNode node=hm.get(key);

        //remove node from its current position
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //put node at front
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
        return node.value;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            ListNode node= hm.get(key);
            node.value=value;
            
            node.prev.next = node.next; //remove
            node.next.prev = node.prev;

            node.next = head.next; //adding at first
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            return;
        }
        ListNode node = new ListNode(key, value);
        hm.put(key, node);

        //put at front
        node.next = head.next;
        node.prev =head;

        head.next.prev =node;
        head.next =node;

        if(hm.size()>capacity){

            ListNode removeNode=tail.prev;

            //remove from list
            removeNode.prev.next = tail;
            tail.prev = removeNode.prev;

            //remove from hashmap
            hm.remove(removeNode.key);
        }   
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */