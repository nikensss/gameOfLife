abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Circle extends Shape {
    private final double r;

    public Circle(double radius) {
        this.r = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * r;
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(r, 2);
    }
}

class Rectangle extends Shape {
    private final double a;
    private final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getPerimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    double getArea() {
        return a * b;
    }
}

class Triangle extends Shape {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        final double s = getS();
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double getS() {
        return getPerimeter() / 2;
    }
}