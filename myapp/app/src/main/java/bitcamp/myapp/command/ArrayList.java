package bitcamp.myapp.command;


import bitcamp.myapp.vo.User;

public class ArrayList {
    private final static int MAX_SIZE = 100;
    private int size = 0;
    private Object[] list = new Object[MAX_SIZE];

    public void add(Object object) {
        list[size++] = object;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        //다음 값을 앞으로 당긴다.
        Object deletedObj = list[index];
        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
        }
        list[--size] = null;
        return deletedObj;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list[i];
        }
        return arr;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (list[i] == obj) {
                return i;
            }
        }
        return -1;
    }


    public int size(){
        return size;
    }

    public Object get(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        return list[index];
    }
}
