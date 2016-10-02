package com.neu.project.DAO;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;


public class UserDAO extends DAO{

    public UserDAO() {
    }
    
    public User get(String username,String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where userId = :username and password = :password");
            q.setString("username", username);
            q.setString("password", username);            
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    
    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUserId(), e);
        }
    }
    
    
    public User create(String username, String password, String firstName, String lastName,String email, long phoneNo, Date date, String street, String city, String state, String zip, String userType)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            
            if(userType.equalsIgnoreCase("A") || userType.equalsIgnoreCase("B")){
            	
            	User user = (User) new Seller();
            	Seller seller = (Seller) user;
//            	Seller user = (Seller) new User();
            	seller.setUserId(username);
            	seller.setPassword(password);
            	seller.setFirstName(firstName);
            	seller.setLastName(lastName);
            	seller.setPhone(phoneNo);
            	seller.setEmail(email);
            	seller.setDob(date);
            	seller.setStreet(street);
            	seller.setCity(city);
            	seller.setState(state);
            	seller.setZip(zip);
            	seller.setUserType(userType);
                getSession().save(seller);
                commit();
                return seller;
            }
            else
            {
            	User user = new User();
            	user.setUserId(username);
            	user.setPassword(password);
            	user.setFirstName(firstName);
            	user.setLastName(lastName);
            	user.setPhone(phoneNo);
            	user.setEmail(email);
            	user.setDob(date);
            	user.setStreet(street);
            	user.setCity(city);
            	user.setState(state);
            	user.setZip(zip);
            	user.setUserType(userType);
                getSession().save(user);
                commit();
                return user;
            }

        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }


}
