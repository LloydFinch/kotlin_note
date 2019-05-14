import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        String format = dateFormat.format(new Date(125600));
        String format2 = dateFormat.format(125600);
        System.out.println(format);
        System.out.println(format2);


        HashMap<String, User> map = new HashMap<>();
        map.put("key1", new User("user1", 21));
        map.put("key2", new User("user2", 22));
        map.put("key3", new User("user3", 23));

        Collection<User> values = map.values();

        List<User> users = new ArrayList<>(values);

        for (User user : users) {
            user.name = "new user";
        }

        Collection<User> values1 = map.values();
        for (User user : values1) {
            System.out.println(user);
        }
    }


    static class User {

        public String name;
        public int age;


        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
