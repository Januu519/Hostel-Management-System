package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ReservationBo extends SuperBo {
    List<Reservation> getAllReservation() throws Exception;

    boolean deleteReservation(String code) throws Exception;

    boolean saveReservation(Reservation dto) throws Exception;

    String generateNewId() throws Exception;

}
