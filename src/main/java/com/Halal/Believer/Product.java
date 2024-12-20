package com.Halal.Believer;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	 @Column(unique = true)
	 private String barcode;
		 public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
		private String productName;
		    private String brand;
		    private double weight;
		    private String flavor;
		    private double price;
		    private Date expiry;
		    private String nutritionalInformation;
		    private String ingredients;

		    private String packagingType;
		    private boolean isVegan;
		    private boolean isGlutenFree;
		    private Date manufacturingDate;
		    private String countryOfOrigin;
		    private boolean halal;
		    public int getAgreeCount() {
				return agreeCount;
			}
			public void setAgreeCount(int agreeCount) {
				this.agreeCount = agreeCount;
			}
			public int getDisagreeCount() {
				return disagreeCount;
			}
			public void setDisagreeCount(int disagreeCount) {
				this.disagreeCount = disagreeCount;
			}
			private int agreeCount;
		    private int disagreeCount;

			public boolean isHalal() {
				return halal;
			}
			public void setHalal(boolean halal) {
				this.halal = halal;
			}
			public String getProductName() {
				return productName;
			}
			public void setProductName(String productName) {
				this.productName = productName;
			}
			public String getBrand() {
				return brand;
			}
			public void setBrand(String brand) {
				this.brand = brand;
			}
			public double getWeight() {
				return weight;
			}
			public void setWeight(double weight) {
				this.weight = weight;
			}
			public String getFlavor() {
				return flavor;
			}
			public void setFlavor(String flavor) {
				this.flavor = flavor;
			}
			public double getPrice() {
				return price;
			}
			public void setPrice(double price) {
				this.price = price;
			}
			public Date getExpiry() {
				return expiry;
			}
			public void setExpiry(Date expiry) {
				this.expiry = expiry;
			}
			public String getNutritionalInformation() {
				return nutritionalInformation;
			}
			public void setNutritionalInformation(String nutritionalInformation) {
				this.nutritionalInformation = nutritionalInformation;
			}
			public String getIngredients() {
				return ingredients;
			}
			public void setIngredients(String ingredients) {
				this.ingredients = ingredients;
			}
			public long getProductId() {
				return id;
			}
			public void setProductId(int productId) {
				this.id = productId;
			}
			public String getPackagingType() {
				return packagingType;
			}
			public void setPackagingType(String packagingType) {
				this.packagingType = packagingType;
			}
			public boolean isVegan() {
				return isVegan;
			}
			public void setVegan(boolean isVegan) {
				this.isVegan = isVegan;
			}
			public boolean isGlutenFree() {
				return isGlutenFree;
			}
			public void setGlutenFree(boolean isGlutenFree) {
				this.isGlutenFree = isGlutenFree;
			}
			public Date getManufacturingDate() {
				return manufacturingDate;
			}
			public void setManufacturingDate(Date manufacturingDate) {
				this.manufacturingDate = manufacturingDate;
			}
			public String getCountryOfOrigin() {
				return countryOfOrigin;
			}
			public void setCountryOfOrigin(String countryOfOrigin) {
				this.countryOfOrigin = countryOfOrigin;
			}





	}



