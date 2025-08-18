class MinStack {
    Stack<Integer>st;
    int mini = Integer.MAX_VALUE;
  
    public MinStack() {
        st=new Stack<>();
       
    }
    
    public void push(int val) {
      if(val<=mini){
        st.push(mini); // Saving the old minimum when a new minimum (or duplicate) is pushed
        mini=val;
      }
      st.push(val);
    }
    
    public void pop() {
        if(!st.isEmpty()){
           int x = st.pop();
           if(x == mini){
             mini=st.pop(); // Restoring the previous minimum when the current minimum is popped.
           }
        }
    }
    
    public int top() {
        if(st.isEmpty()) return Integer.MIN_VALUE;
        return st.peek();
    }
    
    public int getMin() {
        return mini;
        
    }
}


class MinStack {
    Stack<Integer>st;
    Stack<Integer>min_st;
    public MinStack() {
        st=new Stack<>();
        min_st=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(min_st.isEmpty()){
            min_st.push(val);
        }else{
            int min = min_st.peek();
            if(val<=min){
                min_st.push(val);
            }
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
           int x = st.pop();
           if(!min_st.isEmpty() && x==min_st.peek()){
             min_st.pop();
           }
        }
    }
    
    public int top() {
        if(st.isEmpty()) return Integer.MIN_VALUE;
        return st.peek();
    }
    
    public int getMin() {
        if(!min_st.isEmpty()) return min_st.peek();
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
