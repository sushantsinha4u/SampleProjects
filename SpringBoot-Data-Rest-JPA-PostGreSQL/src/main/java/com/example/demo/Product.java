package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.json.JSONException;
import org.json.JSONObject;
 

@Entity
@Audited
@Table(name="product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String name;
    private String cost;

    
    public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;
    
    public Product(){
    }
    
    public Product(String name, Company company){
    	this.name = name;
    	this.company = company;
    }
    
    // name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // products
    public void setCompany(Company company){
    	this.company = company;
    }
    
    public Company getCompany(){
    	return this.company;
    }
    
    public String toString(){
    	String info = "";
    	
        JSONObject jsonInfo = new JSONObject();
        try {
			jsonInfo.put("name",this.name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        JSONObject companyObj = new JSONObject();
        try {
			companyObj.put("name", this.company.getName());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			jsonInfo.put("company", companyObj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        info = jsonInfo.toString();
        return info;
    }
}