class NutritionProgram extends HealthProgram {
    public NutritionProgram(String targetDemographic) {
        super("Nutrition Program", targetDemographic, "nutritional support");
    }

    public void provideFood() {
        System.out.println("Distributing food parcels and supplements to families.");
    }
}
    