public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person mom = new PersonBuilder().setName("Анна").setSurname("Вольф").setAge(31).setAddress("Сидней").build();
        Person son = mom.newChildBuilder().setName("Антошка").build();
        System.out.println("У " + mom + ", есть сын, " + son);

        mom.happyBirthday();
        mom.getAge().ifPresent(i -> System.out.println("Вы стали старше, с днем рождения! Вам " + i));
        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setName("").setSurname("").setAddress("").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}