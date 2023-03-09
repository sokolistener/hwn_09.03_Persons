import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected OptionalInt age;
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(OptionalInt age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException, IllegalArgumentException {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не указаны все необходимые данные (имя и/или фамилия)");
        } else if (this.age.getAsInt() < 0) {
            throw new IllegalArgumentException("Указаны некорректные данные возраста");
        } else {
            return new Person(this);
        }
    }
}

