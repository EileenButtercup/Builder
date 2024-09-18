public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || age == null || address == null)
            throw new IllegalStateException("Не заполнены обязательные поля");
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        return new Person(name, surname, age, address);
    }
}