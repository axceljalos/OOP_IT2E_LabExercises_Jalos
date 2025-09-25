class ScholarshipFund extends EducationProgram {
    public ScholarshipFund(String targetDemographic) {
        super("Scholarship Fund", targetDemographic, "higher education");
    }

    public void awardScholarship() {
        System.out.println("Awarding a scholarship to a deserving student.");
    }
}