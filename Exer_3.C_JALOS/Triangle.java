public class Triangle extends Shape {
    private final float base;
    private final float height;

    public Triangle(float base, float height, float par2) {
        this.base = base;
        this.height = height;
    }

    
    public float CalculateArea() {
        return 0.5f * base * height;
    }

 
    public float CalculatePerimeter() {
        throw new UnsupportedOperationException("Perimeter calculation is not supported for Triangle.");
    }

   
    public String DisplayInfo() {
        return "Triangle with base: " + base + ", height: " + height + 
               ", Area: " + CalculateArea();
    }
}