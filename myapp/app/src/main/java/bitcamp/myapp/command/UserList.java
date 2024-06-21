package bitcamp.myapp.command;

import bitcamp.myapp.vo.User;

public class UserList {
    private static final int MAX_SIZE = 100;
    private  int userLength = 0;
    private  User[] users = new User[MAX_SIZE];
    public void add(User user) {
        this.users[this.userLength++] = user;
    }

    public User delete(int userNo) {
        UserList userList = new UserList();
        User deletedUser = userList.findByNo(userNo);
        if (deletedUser==null) {
            return null;
        }
        //다음 값을 앞으로 당긴다.
        int index = userList.indexOf(deletedUser);
        for (int i = index+1; i < userLength; i++) {
            users[i-1] = users[i];
        }
        users[--userLength] = null;
        return deletedUser;
    }

    public User[] toArray() {
        User[] arr = new User[userLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = users[i];
        }
        return arr;
    }

    public  User findByNo(int userNo) {
        for (int i = 0; i < userLength; i++) {
            User user = users[i];
            if (user.getNo() == userNo) {
                return user;
            }
        }
        return null;
    }

    public  int indexOf(User user) {
        for (int i = 0; i < userLength; i++) {
            if (users[i] == user) {
                return i;
            }
        }
        return -1;
    }
}
