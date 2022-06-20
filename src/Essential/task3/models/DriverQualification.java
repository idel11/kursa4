package Essential.task3.models;

public enum DriverQualification {

    BUS_DRIVER("Bus driver"),
    TRAM_DRIVER("Tram driver");

    private final String qualification;

    DriverQualification(String qualText) {
        this.qualification = qualText;
    }

    public String getQual() {
        return qualification;
    }
}
