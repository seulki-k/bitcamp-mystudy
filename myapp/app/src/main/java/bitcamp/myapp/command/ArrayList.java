package bitcamp.myapp.command;


import java.util.Arrays;

public class ArrayList {
    private final static int MAX_SIZE = 3;
    private int size = 0;
    private Object[] list = new Object[MAX_SIZE];

    public void add(Object object) {
        if (size == list.length) {
            //1) 우리가 만든 메서드를 사용하여 배열 크기 증가
            //grow();

            //2) 자바에서 제공하는 클래스를 사용하여 배열 크기 증가
            int oldSize = list.length;
            int newSize = oldSize + (oldSize >> 1);
            list = Arrays.copyOf(list, newSize); //list = Arrays.copyOf(타켓,변경할 크기); 기존 요소들은 유지하고, 추가된 요소는 기본 값으로 초기화
        }
        list[size++] = object;
    }
//
//    private void grow(){
//        int oldSize = list.length;
//
//        int newSize = oldSize + (oldSize >> 1); // 50% 증가
//
//        Object[] arr = new Object[newSize]; // 새배열 생성
//
//        for (int i = 0; i < list.length; i++) { //기존 배열의 값을 복사해온다.
//            arr[i] = list[i];
//        }
//        list = arr; //기존 배열의 주소를 버리고 새 배열의 주소를 담는다.
//    }

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
        System.arraycopy(list, 0, arr, 0, arr.length);
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


    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return list[index];
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }
}
