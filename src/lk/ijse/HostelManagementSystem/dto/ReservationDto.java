package lk.ijse.HostelManagementSystem.dto;

public class ReservationDto {
    private String reservationId;
    private String date;
    private String studentId;
    private String roomId;
    private String status;

    public ReservationDto() {
    }

    public ReservationDto(String reservationId, String date, String studentId, String roomId, String status) {
        this.reservationId = reservationId;
        this.date = date;
        this.studentId = studentId;
        this.roomId = roomId;
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
                "reservationId='" + reservationId + '\'' +
                ", date='" + date + '\'' +
                ", studentId='" + studentId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
