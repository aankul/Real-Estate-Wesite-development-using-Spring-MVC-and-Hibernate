package com.neu.project.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.hibernate.transform.ResultTransformer;

import com.neu.project.exception.AdException;
import com.neu.project.pojo.Features;
import com.neu.project.pojo.Property;

public class SearchDAO extends DAO{


		
	    public List search(String search, String filterBy, int bhk, int rent, int area, List<String> features)
	            throws AdException {
	        try {
	        	begin();
	            System.out.println("inside DAO");
//	            int page = pageNo;
//	            Query q = getSession().createQuery("from Property where apt = :apt");
//	            q.setString("apt", search);
//	            List list = q.list();

            	Criteria crit = getSession().createCriteria(Property.class,"property");
//            	Criteria crit2 = crit.add(criterion)
            	crit.setFetchMode("property.features", FetchMode.JOIN);
                crit.createAlias("property.features", "feat");
	            Criterion bhkCriterion = Restrictions.eq("bhk",bhk);
	            Criterion rentCriterion = Restrictions.between("rent",rent,rent+1000);
	            Criterion areaCriterion = Restrictions.between("area",area,area+500);
	            Criterion filterByCriterion = Restrictions.ilike(filterBy, search, MatchMode.ANYWHERE);	            
	            Criterion featList = Restrictions.in("feat.featureDesc", features);
//	            ProjectionList projList = Projections.projectionList();
//	            projList.add(Projections.property("propertyId"));
	      
	            
	            Conjunction conjunction = Restrictions.conjunction();
	            conjunction.add(bhkCriterion);
	            conjunction.add(rentCriterion);
	            conjunction.add(areaCriterion);
	            conjunction.add(filterByCriterion);
	            conjunction.add(featList);
/*	            
	            if(features != null)
	            {
	            	for(int i=0;i<features.size();i++) {

	            		conjunction.add(Restrictions.in("features", features.get(i)));
//	            		conjunction.add(Restrictions.eq("features",features.get(i)));  	
	            	}
	            }
*/   
	           
	            crit.add(conjunction);
//	            crit.setFirstResult((page-1)*10);
//	            crit.setMaxResults(2);
//	            crit.setProjection(projList);
//	            crit.setProjection(Projections.distinct(Projections.id()));
	            List<String> list = crit.list();	            
	            commit();
	            return list;
     
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating property: " + e.getMessage());
	        }
	    }

	}

