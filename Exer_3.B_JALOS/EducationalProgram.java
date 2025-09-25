class EducationProgram extends PovertyAlleviationProgram {
    protected final String educationLevel;

    public EducationProgram(String name, String targetDemographic, String educationLevel) {
        super(name, targetDemographic);
        this.educationLevel = educationLevel;
    }

    public void teach() {
        System.out.println("This program teaches skills for " + this.educationLevel + ".");
    }
}
