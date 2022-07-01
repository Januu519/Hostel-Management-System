package lk.ijse.HostelManagementSystem.dao.custom.impl;

import lk.ijse.HostelManagementSystem.dao.custom.UserDao;
import lk.ijse.HostelManagementSystem.entity.User;
import lk.ijse.HostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDaoImpl implements UserDao {
        private Session session;
        private Transaction transaction;
        int newCode;


        @Override
    public String exist() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException, IOException {
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
    public User search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();

        return true;

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        session = FactoryConfiguration.getInstance().getSession();
        transaction = session.beginTransaction();
        User user = session.load(User.class,s);
        session.delete(user);
        transaction.commit();
        session.close();
        return true;
    }
}
