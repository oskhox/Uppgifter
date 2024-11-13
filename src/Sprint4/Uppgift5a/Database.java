package Sprint4.Uppgift5a;

import java.util.ArrayList;
import java.util.List;

//Database of person objects
public class Database {

    private final Person p1 = new Person("Alice Johnson", "1990-05-15", "alice.johnson@example.com", "+1-555-1234");
    private final Person p2 = new Person("Bob Smith", "1985-08-20", "bob.smith@example.com", "+1-555-2345");
    private final Person p3 = new Person("Carol White", "1992-11-30", "carol.white@example.com", "+1-555-3456");
    private final Person p4 = new Person("David Brown", "1978-04-02", "david.brown@example.com", "+1-555-4567");
    private final Person p5 = new Person("Evelyn Green", "1983-09-12", "evelyn.green@example.com", "+1-555-5678");

    private final List<Person> allPersons = new ArrayList<>();

    public Database() {
        allPersons.add(p1);
        allPersons.add(p2);
        allPersons.add(p3);
        allPersons.add(p4);
        allPersons.add(p5);
    }

    //Searches the database and returns an already formatted String if there is a match
    public String search(String name) {
        for (Person p : allPersons) {
            if (p.getName().equalsIgnoreCase(name)) {
                return "Name: " + p.getName() + ". Birthday: " + p.getBirthday() + ". E-mail: " + p.getEmail() + ". Phone number: " + p.getPhoneNumber() + ".";
            }
        }
        //If no match
        return "This person was not found in the database.";
    }
}