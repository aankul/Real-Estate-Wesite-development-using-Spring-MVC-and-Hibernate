package com.neu.project.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Features;


public class FeatureDAO extends DAO {
	
    public Features get(String title) throws AdException {
        try {
            begin();
            Query q=getSession().createQuery("from Features where featureDesc= :featureDesc");
            q.setString("featureDesc",title);
            Features feature=(Features)q.uniqueResult();
            commit();
            return feature;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not obtain the named Feature " + title + " " + e.getMessage());
        }
    }

    public List<Features> list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Features");
			@SuppressWarnings("unchecked")
			List<Features> list = (List<Features>) q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the Features", e);
        }
    }

    public Features create(String title) throws AdException {
        try {
            begin();
            Features feature = new Features();
            feature.setFeatureDesc(title);
            getSession().save(feature);
            commit();
            return null;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create the category", e);
            throw new AdException("Exception while creating feature: " + e.getMessage());
        }
    }

    public void save(Features category) throws AdException {
        try {
            begin();
            getSession().update(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not save the feature", e);
        }
    }

    public void delete(Features category) throws AdException {
        try {
            begin();
            getSession().delete(category);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete the feature", e);
        }
    }

}
