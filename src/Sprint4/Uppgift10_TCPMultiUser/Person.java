package Sprint4.Uppgift10_TCPMultiUser;

import java.io.Serializable;

public class Person implements Serializable {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "The person is " + name + ", aged " + age + ".";
     }
}
