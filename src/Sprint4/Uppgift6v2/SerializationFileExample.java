package Sprint4.Uppgift6v2;

import java.io.*;

//This is a basic one-file example to show serialization in the easiest possible way

//Serializable class
class Person implements Serializable {
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

//Main class that includes both writing and reading
public class SerializationFileExample {

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        //Serialize the object (write to file)
        serializeObject(person);

        //Deserialize the object (read from file)
        Person deserializedPerson = deserializeObject();
        if (deserializedPerson != null) {
            System.out.println("Object read from file: " + deserializedPerson);
        }
    }

    //Method to serialize (write with ObjectOutputStream) the object to a file
    private static void serializeObject(Person person) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            out.writeObject(person);  //Serialize and write the object to the file
            System.out.println("Object written to file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method to deserialize (read with ObjectInputStream) the object from the file
    private static Person deserializeObject() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.txt"))) {
            return (Person) in.readObject();  //Deserialize the object from the file
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}