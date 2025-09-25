public class Poverty {
    public static void main(String[] args) {
        System.out.println("--- Creating Poverty Alleviation Program Instances ---");

        
        MicrofinanceInitiative microfinance = new MicrofinanceInitiative("small business owners", 500.00);
        VocationalTraining vocational = new VocationalTraining("unemployed youth", "Carpentry");

       
        LiteracyProgram literacy = new LiteracyProgram("adult learners");
        ScholarshipFund scholarship = new ScholarshipFund("high school graduates");

        
        NutritionProgram nutrition = new NutritionProgram("at-risk children");
        HealthcareAccess healthcare = new HealthcareAccess("rural communities");

        System.out.println("\n--- Testing All Programs ---");

        System.out.println("\nTesting Microfinance Initiative:");
        microfinance.describeProgram();
        microfinance.provideResources();
        microfinance.provideLoan();

        System.out.println("\nTesting Vocational Training:");
        vocational.describeProgram();
        vocational.provideResources();
        vocational.trainParticipants();

        System.out.println("\nTesting Literacy Program:");
        literacy.describeProgram();
        literacy.teach();
        literacy.teachReading();
        
        System.out.println("\nTesting Scholarship Fund:");
        scholarship.describeProgram();
        scholarship.teach();
        scholarship.awardScholarship();
        
        System.out.println("\nTesting Nutrition Program:");
        nutrition.describeProgram();
        nutrition.provideHealthService();
        nutrition.provideFood();
        
        System.out.println("\nTesting Healthcare Access:");
        healthcare.describeProgram();
        healthcare.provideHealthService();
        healthcare.offerConsultation();
    }
}
