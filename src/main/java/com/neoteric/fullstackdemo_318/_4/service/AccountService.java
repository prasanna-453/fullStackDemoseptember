package com.neoteric.fullstackdemo_318._4.service;

import com.neoteric.fullstackdemo_318._4.exception.AccountCreationFailedException;
import com.neoteric.fullstackdemo_318._4.hybernate.HibernateUtils;
import com.neoteric.fullstackdemo_318._4.model.Account;
import com.neoteric.fullstackdemo_318._4.model.AccountEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;


public class AccountService {

    public String createAccountUsingHibernate(Account account){
        SessionFactory sessionFactory= HibernateUtils.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();


        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setAccountNumber(UUID.randomUUID().toString());
        accountEntity.setName(account.getName());
        accountEntity.setPan( account.getPan());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setMobileNumber(account.getMobileNumber());
        session.persist(accountEntity);
        transaction.commit();
        return accountEntity.getAccountNumber();


    }

    public String createAccount(Account account)
            throws AccountCreationFailedException{
        String accountnumber=null;
        try {


            Connection connection = DBConnection.getConnection();
            Statement stmt = connection.createStatement();

            String accountNumber = UUID.randomUUID().toString();

            String query = "insert into bank.account values(" +
                    "'" + accountNumber + "," + ","
                    + "'" + account.getName() + "'"
                    + "," + account.getPan() + "," +
                    "'" + account.getMobileNumber() + "'" + ","
                    + account.getBalance() + ")";

            int status = stmt.executeUpdate(query);

            if (status==1) {
                System.out.println("Account is created" + accountNumber);
            } else {

                throw new AccountCreationFailedException("Account creation is failed"+account.getPan());
            }
            }catch (SQLException e) {
            System.out.println("sqlException" + e);
        }
        catch (AccountCreationFailedException e){
            System.out.println("AccountCreationFailedException"+e);

            }

        return accountnumber;
    }
}
