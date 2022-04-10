package com.demo.springbatchdemo.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVoBatch {

	@Id
	private int id;
	private String name;
	private String description;
	private long price;
	private int quantity;
	private String company;
	private Date timestamp;
	
	
//	public ProductVoBatch(int id, String name, String description, long price, int quantity, String company,
//			Date timestamp) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.description = description;
//		this.price = price;
//		this.quantity = quantity;
//		this.company = company;
//		this.timestamp = timestamp;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
