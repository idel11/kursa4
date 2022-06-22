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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public DriverQualification getQualification() {
        return qualification;
    }

    public void setQualification(DriverQualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", qualification=" + qualification +
                '}';
    }
}
