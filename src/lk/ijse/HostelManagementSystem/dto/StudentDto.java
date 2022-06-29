package lk.ijse.HostelManagementSystem.dto;

public class StudentDto {
    private String stId;
    private String stName;
    private String stAddress;
    private int contact;
    private String dob;
    private String gender;

    public StudentDto() {
    }

    public StudentDto(String stId, String stName, String stAddress, int contact, String dob, String gender) {
        this.stId = stId;
        this.stName = stName;
        this.stAddress = stAddress;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStAddress() {
        return stAddress;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "stId='" + stId + '\'' +
                ", stName='" + stName + '\'' +
                ", stAddress='" + stAddress + '\'' +
                ", contact=" + contact +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
