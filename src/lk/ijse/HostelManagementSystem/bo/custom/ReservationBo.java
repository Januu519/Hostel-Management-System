package lk.ijse.HostelManagementSystem.bo.custom;

import lk.ijse.HostelManagementSystem.bo.SuperBo;
import lk.ijse.HostelManagementSystem.entity.Reservation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReservationBo extends SuperBo {
    ArrayList<Reservation> getAllReservation() throws SQLException, ClassNotFoundException;

    boolean deleteReservation(String code) throws SQLException, ClassNotFoundException;

    boolean saveReservation(Reservation dto) throws SQLException, ClassNotFoundException, IOException;

    String generateNewId() throws SQLException, ClassNotFoundException, IOException;

}
