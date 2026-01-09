class LiteracyProgram extends EducationProgram {
    public LiteracyProgram(String targetDemographic) {
        super("Literacy Program", targetDemographic, "basic literacy");
    }

    public void teachReading() {
        System.out.println("Teaching basic reading and writing to individuals.");
    }
}