package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.ReservationDao;
import lk.ijse.HostelManagementSystem.entity.Reservation;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {
    private Session session;
    private Transaction transaction;

    @Override
    public String exist() throws Exception{
        return null;
    }

    @Override
    public String generateNewID() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createSQLQuery("SELECT res_id FROM RoomReservation ORDER BY res_id DESC LIMIT 1");
        String id = (String) query.uniqueResult();
        int newCustomerId = Integer.parseInt(id.replace("RID-", "")) + 1;
        transaction.commit();
        return String.format("RID-%03d", newCustomerId);

    }

    @Override
    public List getAll() throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Reservation");
        List<Reservation> list = query.list();
        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public boolean save(Object dto) throws Exception {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public ArrayList<String> searchId() throws Exception{
        return null;
    }

    @Override
    public Object search(Object o) throws Exception {
        return null;
    }

    @Override
    public boolean update(Object dto) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Object o) throws Exception {
        return false;
    }
}
