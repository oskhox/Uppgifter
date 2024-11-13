package Sprint4.Uppgift5a;

public class Person {

    private final String name;
    private final String birthday;
    private final String email;
    private final String phoneNumber;

    public Person(String name, String birthday, String email, String phoneNumber) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}