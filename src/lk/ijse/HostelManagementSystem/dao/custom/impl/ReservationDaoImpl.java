package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.ReservationDao;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    private Session session;
    private Transaction transaction;

    @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();

        String hql = "FROM Reservation ORDER BY resId DESC ";
        List<Reservation> reservationList = session.createQuery(hql).list();
        for (Reservation reservation: reservationList) {
            String  lastId = reservation.getResId();
            return lastId;
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public ArrayList getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Object dto) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<String> searchId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Object search(Object o) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Object dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(Object o) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }
}
