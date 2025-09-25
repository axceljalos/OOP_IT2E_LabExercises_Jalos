class EconomicEmpowermentProgram extends PovertyAlleviationProgram {
    protected final String focusArea;

    public EconomicEmpowermentProgram(String name, String targetDemographic, String focusArea) {
        super(name, targetDemographic);
        this.focusArea = focusArea;
    }

    public void provideResources() {
        System.out.println("This program provides resources for economic development, focusing on " + this.focusArea + ".");
    }
}
