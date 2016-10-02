package com.neu.project.DAO;



import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Cart;
import com.neu.project.pojo.Features;
import com.neu.project.pojo.Message;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.User;

public class MessageDAO extends DAO{
	
	   public void postMessage(String userTo,String messageBody,User user)
	            throws AdException {
	        try {
	            begin();
	            System.out.println("inside DAO");
	            Calendar calendar = Calendar.getInstance();
	            Message message = new Message();
	            message.setToUser(userTo);
	            message.setMessage(messageBody);
	            message.setMessageDate(new Date());
	            message.setUser(user);
	            user.getMessageList().add(message);
	            getSession().save(message);
	            commit();
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while posting Message: " + e.getMessage());
	        }
	    }

	    public List getInbox(String user) throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("from Message where toUser = :toUser");
	            q.setString("toUser",user);
				List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the Messages", e);
	        }
	    }
		
	    public void AddToCartMethod(Long propertyId, User user) throws AdException {
	        try {
	            begin();
	            Cart cart = new Cart();
	            cart.setPropertyId(propertyId);
	            cart.setUser(user);
	            user.getCartList().add(cart);
	            getSession().save(cart);
	            commit(); 
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not add Property to cart", e);
	        }
	    }
	    
	    public List getCart(String personId) throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("select propertyId from Cart where personId = :personId");
	            Long person = Long.parseLong(personId);
	            q.setLong("personId", person);
				List list = q.list();
				Criteria crit = getSession().createCriteria(Property.class);
				crit.add(Restrictions.in("propertyId", list ));
				List propertyList = crit.list();
	            commit();
	            return propertyList;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties in cart", e);
	        }
	    }
	    
	    
	    public List checkCart(String personId) throws AdException {
	        try {
	            begin();
	            Query q = getSession().createQuery("select propertyId from Cart where personId = :personId");
	            Long person = Long.parseLong(personId);
	            q.setLong("personId", person);
				List list = q.list();
	            commit();
	            return list;
	        } catch (HibernateException e) {
	            rollback();
	            throw new AdException("Could not list the properties in cart", e);
	        }
	    }     
	    
	}
