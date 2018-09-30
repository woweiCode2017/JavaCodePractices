package Practices.RPCs;

import java.io.Serializable;

/**
 * Created by 11239 on 2018/8/22.
 */
public class Person implements Serializable{

    private static final long serialVersionUID=10086;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
