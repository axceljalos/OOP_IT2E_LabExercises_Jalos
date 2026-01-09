public class Circle extends Shape {
    private float radius;
    final float PI = 3.3314f;

    public Circle(float radius) {
        super();
        this.radius = radius;
    }

    public float CalculateArea() {
        float area = PI * radius * radius;
        return area;
    }

    
    public String DisplayInfo() {
        return "Circle with radius: " + radius + ", Area: " + CalculateArea() + ", Perimeter: " + CalculatePerimeter()  ;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
    
    public float getRadius() {
        return radius;
    }

    
    public float CalculatePerimeter() {
        return 2 * PI * radius;
    }
    
}