class VocationalTraining extends EconomicEmpowermentProgram {
    private final String skill;

    public VocationalTraining(String targetDemographic, String skill) {
        super("Vocational Training Program", targetDemographic, "job skills");
        this.skill = skill;
    }

    public void trainParticipants() {
        System.out.println("Training participants in the skill of " + this.skill + ".");
    }
}