package LR2;

public class Task8 {
    // Базовый класс Animal
    static class Animal {
        protected String name;
        protected int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void sound() {
            System.out.println("Животное издаёт звук");
        }

        public String getName() { return name; }
        public int getAge() { return age; }
    }

    // Собака
    static class Dog extends Animal {
        private String breed; // порода

        public Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        @Override
        public void sound() {
            System.out.println("Гав");
        }

        public String getBreed() { return breed; }
    }

    // Кошка
    static class Cat extends Animal {
        private String foodType; // тип корма

        public Cat(String name, int age, String foodType) {
            super(name, age);
            this.foodType = foodType;
        }

        @Override
        public void sound() {
            System.out.println("Мяу");
        }

        public String getFoodType() { return foodType; }
    }

    // Птица
    static class Bird extends Animal {
        private boolean canFly;

        public Bird(String name, int age, boolean canFly) {
            super(name, age);
            this.canFly = canFly;
        }

        @Override
        public void sound() {
            System.out.println("Чик");
        }

        public boolean canFly() { return canFly; }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Мухтар", 3, "Овчарка");
        Cat cat = new Cat("Киса", 2, "Рыба");
        Bird bird = new Bird("Кеша", 1, true);

        System.out.println(dog.getName() + " (" + dog.getBreed() + "): ");
        dog.sound();

        System.out.println(cat.getName() + " (любит " + cat.getFoodType() + "): ");
        cat.sound();

        System.out.println(bird.getName() + " (летает? " + bird.canFly() + "): ");
        bird.sound();
    }
}
