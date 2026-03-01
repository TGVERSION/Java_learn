package LR2;

public class Task5 {
    static class Rectangle {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() { return length; }
        public void setLength(double length) { this.length = length; }

        public double getWidth() { return width; }
        public void setWidth(double width) { this.width = width; }

        public double area() {
            return length * width;
        }

        public double perimeter() {
            return 2 * (length + width);
        }
    }

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5.0, 3.0);
        System.out.println("Длина: " + rect.getLength());
        System.out.println("Ширина: " + rect.getWidth());
        System.out.println("Площадь: " + rect.area());
        System.out.println("Периметр: " + rect.perimeter());
    }
}