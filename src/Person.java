import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    protected boolean hasAgeFlag;


    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
        if (this.age.isPresent()) {
            this.hasAgeFlag = true;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder().setSurname(this.getSurname()).setAge(OptionalInt.of(0)).setAddress(this.getAddress());
        return child;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public void happyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }


    @Override
    public String toString() {
        return name + " " + surname + ", " + age.getAsInt() + " лет, из " + address;
    }
}

