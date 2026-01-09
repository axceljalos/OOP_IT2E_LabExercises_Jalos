public class Square extends Shape {
    private final float side;

    public Square(float side) {
        this.side = side;
    }

    
    public float CalculateArea() {
        return side * side;
    }

    
    public float CalculatePerimeter() {
        return 4 * side;
    }

  
    public String DisplayInfo() {
        return "Square with side: " + side + 
               ", Area: " + CalculateArea() + 
               ", Perimeter: " + CalculatePerimeter();
    }
}