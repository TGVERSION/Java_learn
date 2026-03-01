package LR2;

public class Task6 {
    // Интерфейс
    interface Shape {
        double area();
        double perimeter();
    }

    // Круг
    static class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }

        @Override
        public double perimeter() {
            return 2 * Math.PI * radius;
        }
    }

    // Квадрат
    static class Square implements Shape {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double area() {
            return side * side;
        }

        @Override
        public double perimeter() {
            return 4 * side;
        }
    }

    // Треугольник
    static class Triangle implements Shape {
        private double a, b, c;

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double area() {
            double p = perimeter() / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }

        @Override
        public double perimeter() {
            return a + b + c;
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 4, 5);

        System.out.println("Круг: площадь = " + circle.area() + ", периметр = " + circle.perimeter());
        System.out.println("Квадрат: площадь = " + square.area() + ", периметр = " + square.perimeter());
        System.out.println("Треугольник: площадь = " + triangle.area() + ", периметр = " + triangle.perimeter());
    }
}