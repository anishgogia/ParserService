package com.pie.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Competetion")
public class Competetion {

	int id;
	Boolean active;
	@NotNull(message="can not be null")
	String url;
	
	
	int formno;
	
	int numberfields;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date endDate;
	Date dateCreated;
	@NotNull(message="can not be null")
	String finalurl;
	
	@Column(name="finalurl")
    public String getFinalurl() {
		return finalurl;
	}

	public void setFinalurl(String finalurl) {
		this.finalurl = finalurl;
	}

	

	
	
	public Competetion() {

	}

	public Competetion(int id, boolean active, String url, int formno, int numberfields, Date startDate, Date endDate,
			Date dateCreated) {
		super();
		this.id = id;
		this.active = active;
		this.url = url;
		this.formno = formno;
		this.numberfields = numberfields;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Competetion [id=" + id + ", active=" + active + ", url=" + url + ", formno=" + formno
				+ ", numberfields=" + numberfields + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", dateCreated=" + dateCreated + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "IsActive")
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
	@Column(name = "Url", nullable=true)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(nullable=false,name = "FormNo")
	public int getFormno() {
		return formno;
	}

	public void setFormno(int formno) {
		this.formno = formno;
	}

	@Column(nullable=false,name = "NumberFields")
	public int getNumberfields() {
		return numberfields;
	}

	public void setNumberfields(int numberfields) {
		this.numberfields = numberfields;
	}

	@Column(name = "StartDate")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "EndDate")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "DateCreated")
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
