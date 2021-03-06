package lk.ijse.HostelManagementSystem.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Reservation {
    @Id
    private String resId;
    private String roomTypeId;
    private String studentId;
    private String date;
    private String status;


}
