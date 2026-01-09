class HealthProgram extends PovertyAlleviationProgram {
    protected final String serviceType;

    public HealthProgram(String name, String targetDemographic, String serviceType) {
        super(name, targetDemographic);
        this.serviceType = serviceType;
    }

    public void provideHealthService() {
        System.out.println("This program provides " + this.serviceType + " health services.");
    }
}
