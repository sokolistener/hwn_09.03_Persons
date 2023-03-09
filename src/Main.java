import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(OptionalInt.of(31))
                .setAddress("Сидней")
                .build();
        mom.happyBirthday();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        son.happyBirthday();
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println(mom.hasAge());
        System.out.println(son.hasAddress());
        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Анатолий").setSurname("Борисов").setAge(OptionalInt.of(-100)).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}