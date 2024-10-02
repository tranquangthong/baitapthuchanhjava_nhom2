import java.util.Scanner;

// Lớp cha Shape (Hình dạng)
abstract class Shape {
    public abstract double getArea();  // Phương thức trừu tượng tính diện tích
    public abstract double getPerimeter();  // Phương thức trừu tượng tính chu vi
}

// Lớp Circle (Hình tròn)
class Circle extends Shape {
    private final double radius;  // Bán kính

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;  // Diện tích hình tròn
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;  // Chu vi hình tròn
    }
}

// Lớp Rhombus (Hình thoi)
class Rhombus extends Shape {
    private final double diagonal1;  // Đường chéo thứ nhất
    private final double diagonal2;  // Đường chéo thứ hai
    private final double side;  // Cạnh

    public Rhombus(double diagonal1, double diagonal2, double side) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.side = side;
    }

    @Override
    public double getArea() {
        return (diagonal1 * diagonal2) / 2;  // Diện tích hình thoi
    }

    @Override
    public double getPerimeter() {
        return 4 * side;  // Chu vi hình thoi
    }
}

// Lớp Rectangle (Hình chữ nhật)
class Rectangle extends Shape {
    private final double length;  // Chiều dài
    private final double width;   // Chiều rộng

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;  // Diện tích hình chữ nhật
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);  // Chu vi hình chữ nhật
    }
}

public class BaiTap {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){

        // Nhập thông tin cho hình tròn
        System.out.print("Nhập bán kính hình tròn: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("Diện tích hình tròn: " + circle.getArea());
        System.out.println("Chu vi hình tròn: " + circle.getPerimeter());

        // Nhập thông tin cho hình thoi
        System.out.print("Nhập đường chéo thứ nhất của hình thoi: ");
        double diagonal1 = scanner.nextDouble();
        System.out.print("Nhập đường chéo thứ hai của hình thoi: ");
        double diagonal2 = scanner.nextDouble();
        System.out.print("Nhập cạnh của hình thoi: ");
        double side = scanner.nextDouble();
        Rhombus rhombus = new Rhombus(diagonal1, diagonal2, side);
        System.out.println("Diện tích hình thoi: " + rhombus.getArea());
        System.out.println("Chu vi hình thoi: " + rhombus.getPerimeter());

        // Nhập thông tin cho hình chữ nhật
        System.out.print("Nhập chiều dài của hình chữ nhật: ");
        double length = scanner.nextDouble();
        System.out.print("Nhập chiều rộng của hình chữ nhật: ");
        double width = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(length, width);
        System.out.println("Diện tích hình chữ nhật: " + rectangle.getArea());
        System.out.println("Chu vi hình chữ nhật: " + rectangle.getPerimeter());
        
        scanner.close();
        }
    }
}
