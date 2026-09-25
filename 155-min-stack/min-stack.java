class MinStack {
    Stack<Integer> s;
    PriorityQueue<Integer> pq;
    public MinStack() {
        s= new Stack<>();
        pq= new PriorityQueue<>(); //min heap
        
    }
    
    public void push(int value) {
        s.push(value);
        pq.offer(value);
    }
    
    public void pop() {
        int top= s.pop();
        pq.remove(top);
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */