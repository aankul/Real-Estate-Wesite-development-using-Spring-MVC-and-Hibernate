package com.neu.project.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="property")
public class Property {	
	
	@Id
	@GeneratedValue
	@Column(name="propertyId")
	private long propertyId;
	
	@Column(name="apt")
	private String apt;

	@Column(name="street")
	private String street;

	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;

	@Column(name="zip")
	private String zip;
	
	@Column(name="area")
	private int area;
	
	@Column(name="rent")
	private int rent;
	
	@Column(name="bhk")
	private int bhk;
		
	@Column(name="photoName")
	private String photoName;

	@Column(name="image", columnDefinition="BLOB")
	private byte[] image;
	
	@ManyToOne
	@JoinColumn(name="personId")	
	private Seller seller;	
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "property_features",joinColumns = { 
			@JoinColumn(name = "propertyId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "featureId", 
					nullable = false, updatable = false) })
	private Set<Features> features = new HashSet<Features>();
	
	
    @Transient
    private String[] feature_name;
    
	public String[] getFeature_name() {
		return feature_name;
	}

	public void setFeature_name(String[] feature_name) {
		this.feature_name = feature_name;
	}

	public Set<Features> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Features> features) {
		this.features = features;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getBhk() {
		return bhk;
	}

	public void setBhk(int bhk) {
		this.bhk = bhk;
	}	
}
