//最近请求次数
class RecentCounter {

    private LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }
}

//约瑟夫问题II
public class Joseph {
    public int getResult(int n) {
        LinkedList<Integer> res=new LinkedList<Integer>();
        int round=2,i=0,curr=0;
        for( i=1;i<=n;i++) {
            res.add(i);
        }
        while(res.size()>1) {
            i=0;
            while(res.size()>1&&i<res.size()) {
                curr=(curr+1)%round;
                if(curr!=1)res.remove(i);
                else i++;
            }
            round++;
            curr=0;
            if(res.size()>1) {
                int last=res.removeLast();
                res.addFirst(last);
            }
        }
       return res.pop();
    }
}

//猫狗收容所
public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        Queue<Integer> dog=new LinkedList<Integer>();
        Queue<Integer> cat=new LinkedList<Integer>();
        Queue<Integer> all=new LinkedList<Integer>();
        ArrayList<Integer> animal=new ArrayList<Integer>();
        for(int i=0;i<ope.length;i++) {
            if(ope[i][0]==1) {
                all.add(ope[i][1]);
                if(ope[i][1]>0) {
                    dog.add(ope[i][1]);
                } else if(ope[i][1]<0) {
                    cat.add(ope[i][1]);
                }
            }
            else if(ope[i][0]==2) {
                if(ope[i][1]==0) {
                    if(!all.isEmpty()) {
                        //看最先被领养的是猫还是狗 同步删除猫或狗中的stack
                        int temp=all.poll();
                        animal.add(temp);
                        if(temp>0) {
                            dog.poll();
                        }else {
                            cat.poll();
                        }
                    }
                }
                else if(ope[i][1]>0) {
                    if(!dog.isEmpty()) {
                        //看最先被领养的是猫还是狗 同步删除混合stack中的值
                        int temp=dog.poll();
                        animal.add(temp);
                        all.remove(temp);
                    }
                }
                else {
                    if(!cat.isEmpty()) {
                        //看最先被领养的是猫还是狗 同步删除混合stack中的值
                        int temp=cat.poll();
                        animal.add(temp);
                        all.remove(temp);
                    }
                }
            }
        }
        return animal;
    }
}

//员工重要性
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e:employees) {
            if(e.id == id) {
                if(e.subordinates.size() == 0) {
                    return e.importance;
                }
                for(int subId : e.subordinates) {
                    e.importance += getImportance(employees,subId);
                }
                return e.importance;
            }
        }
        return 0;
    }
}

//设计循环双端队列
class MyCircularDeque {


    private int[] elements;
    private int size;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        elements = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        for(int i = size - 1; i >= 0; i--) {
            elements[i+1] = elements[i];
        }
        elements[0] = value;
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()) {
            return false;
        }
        elements[size] = value;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        elements[0] = 0;
        for(int i = 0; i < size-1; i++) {
            elements[i] = elements[i+1];
        }
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        elements[size-1] = 0;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : elements[0];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : elements[size-1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == elements.length;
    }
}

//比较含退格的字符串
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }


    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}

//棒球比赛
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack();
        for(String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newtop = top + stack.peek();
                stack.push(top);
                stack.push(newtop);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        int ans = 0;
        for(int score : stack) ans += score;
        return ans;
    }
}

//栈的弹出压入序列
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> st = new Stack<Integer>();
        int i = 0;
        int j = 0;
        st.push(pushA[i++]);
        while(j <= popA.length-1){
            while(popA[j] != st.peek()){
                if(i == pushA.length) {
                    return false;
                }else {
                    st.push(pushA[i++]);
                }
            }
            j++;
            st.pop();
        }
        return true;
    }
}

//逆波兰表达式求值
class Solution {
    public int evalRPN(String[] tokens) {
        int[] numStack = new int[tokens.length / 2 + 1];
        int index = 0;
        for (String s : tokens) {
            switch (s) {
            case "+":
                numStack[index - 2] += numStack[--index];
                break;
            case "-":
                numStack[index - 2] -= numStack[--index];
                break;
            case "*":
                numStack[index - 2] *= numStack[--index];
                break;
            case "/":
                numStack[index - 2] /= numStack[--index];
                break;
            default:
                numStack[index++] = Integer.parseInt(s);
                break;
            }
        }
        return numStack[0];
    }
}

//股票价格跨度
class StockSpanner {
    Stack<Integer> prices, weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += weights.pop();
        }

        prices.push(price);
        weights.push(w);
        return w;
    }
}