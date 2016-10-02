package com.neu.project.DAO;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Features;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;

public class PropertyDAO extends DAO {
	
	
    public Property create(String apt,String street,String city,String state,String zip,String photoName,Seller seller, Set<Features> features, int rent, int bhk, int area)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            Property property = new Property();
            
            property.setApt(apt);
            property.setStreet(street);
            property.setCity(city);
            property.setState(state);
            property.setZip(zip);
            property.setPhotoName(photoName);
            property.setFeatures(features);
            property.setSeller(seller);
            property.setArea(area);
            property.setBhk(bhk);
            property.setRent(rent);
            seller.addProperty(property);
            getSession().save(property);
            
            commit();
            return property;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating property: " + e.getMessage());
        }
    }
    
    
    public Property get(String id) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Property where propertyId = :propertyId");
            q.setString("propertyId",id);
            Property property = (Property)q.uniqueResult();
            commit();
            return property;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named property " + id + " " + e.getMessage());
        }
    }

}
