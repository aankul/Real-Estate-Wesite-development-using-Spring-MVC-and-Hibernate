package com.neu.project.pojo;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="features")
public class Features {
	
	public Features() {
	}	
	
	public Features(long featureId, String featureDesc) {
		this.featureId = featureId;
		this.featureDesc = featureDesc;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "featureId", unique = true, nullable = false)
	private long featureId;
	
	@Column(name = "featureDesc")
	private String featureDesc;

	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "features")
	private Set<Property> property = new HashSet<Property>(0);
	

	public long getFeatureId() {
		return featureId;
	}
	public void setFeatureId(long featureId) {
		this.featureId = featureId;
	}

	
	public String getFeatureDesc() {
		return featureDesc;
	}
	public void setFeatureDesc(String featureDesc) {
		this.featureDesc = featureDesc;
	}
	public Set<Property> getProperty() {
		return property;
	}
	public void setProperty(Set<Property> property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return featureDesc;
	}
	
	
	
	
}
