class HealthcareAccess extends HealthProgram {
    public HealthcareAccess(String targetDemographic) {
        super("Healthcare Access Program", targetDemographic, "medical care");
    }

    public void offerConsultation() {
        System.out.println("Offering free medical consultations and check-ups.");
    }
}