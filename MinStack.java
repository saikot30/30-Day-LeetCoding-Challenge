/*
 *	Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *	push(x) -- Push element x onto stack.
 *	pop() -- Removes the element on top of the stack.
 *	top() -- Get the top element.
 *	getMin() -- Retrieve the minimum element in the stack.
 * 
 *
 *	Example:
 *
 *	MinStack minStack = new MinStack();
 *	minStack.push(-2);
 *	minStack.push(0);
 *	minStack.push(-3);
 *	minStack.getMin();   --> Returns -3.
 *	minStack.pop();
 *	minStack.top();      --> Returns 0.
 *	minStack.getMin();   --> Returns -2.
 */
class MinStack {
    public static Stack<Integer> st;
    public static Stack<Integer> min_st;

    /** initialize your data structure here. */
    public MinStack() {
        this.st = new Stack<Integer>();
        this.min_st = new Stack<Integer>();
    }
    
    public void push(int x) {
        st.push(x);
        if(min_st.empty()) min_st.push(x);
        else {
            if(st.peek() <= min_st.peek()) min_st.push(x);
            //else min_st.push(min_st.peek());
        }
    }
    
    public void pop() {
        int temp = st.pop();
        if(temp == min_st.peek()) {
            min_st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min_st.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */