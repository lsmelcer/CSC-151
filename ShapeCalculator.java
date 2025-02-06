import java.util.Scanner;

// Abstract Shape Class
abstract class Shape {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

// Circle Class
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle Class
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
}

// Triangle Class
class Triangle extends Shape {
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

// Main Program to calculate and compare results
public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            // Display menu
            System.out.println("Shape Calculator");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Please choose a shape (1-4): ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Circle
                    System.out.print("Enter the radius of the circle: ");
                    double radius = scanner.nextDouble();
                    Circle circle = new Circle(radius);
                    displayResults(circle);
                    break;
                case 2:
                    // Rectangle
                    System.out.print("Enter the width of the rectangle: ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter the height of the rectangle: ");
                    double height = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(width, height);
                    displayResults(rectangle);
                    break;
                case 3:
                    // Triangle
                    System.out.print("Enter the base of the triangle: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the height of the triangle: ");
                    double triangleHeight = scanner.nextDouble();
                    System.out.print("Enter the 3 sides of the triangle: ");
                    double side1 = scanner.nextDouble();
                    double side2 = scanner.nextDouble();
                    double side3 = scanner.nextDouble();
                    Triangle triangle = new Triangle(base, triangleHeight, side1, side2, side3);
                    displayResults(triangle);
                    break;
                case 4:
                    // Exit
                    continueRunning = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    // Method to display the results
    public static void displayResults(Shape shape) {
        System.out.println("Area: " + shape.calculateArea());
        System.out.println("Perimeter: " + shape.calculatePerimeter());
        System.out.println();
    }
}
