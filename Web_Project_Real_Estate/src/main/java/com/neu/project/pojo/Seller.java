package com.neu.project.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="seller")
@PrimaryKeyJoinColumn(name="personId")
public class Seller extends User {
	
	
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Property> propertyList = new ArrayList<Property>();
	
//	@OneToMany(targetEntity=Property.class, mappedBy="seller", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public List<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
    public void addProperty(Property property) {
    	propertyList.add( property );

    }

    public void removeProperty(Property property) {
    	propertyList.remove( property );
    	property.setSeller(null);
    }

	@Override
	public String toString() {
		return getUserId();
	}
	
    
    
}
