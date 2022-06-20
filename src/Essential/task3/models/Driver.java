package Essential.task3.models;

public class Driver {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private DriverQualification qualification;

    public Driver(int id, String name, String surname,
                  String phoneNumber, DriverQualification qualification) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.qualification = qualification;
    }
}
