package bitcamp.myapp.util;

public class Queue extends LinkedList {
    public void off(Object value) {
        add(value);
    }

    public Object poll() {
        return remove(0);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.off(111);
        q.off(222);
        q.off(333);
        
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }
}
