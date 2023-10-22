package com.pie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CompetetionFields")
public class CompetetionEntity {
	int Id;
	int competetionid;
	String fieldtype;
	String fieldname;
	String fieldid;
	String userData;
	String code;
	
	
	@Column(name = "Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CompetetionEntity(){
		
	}
	
     public CompetetionEntity(int id){
		this.competetionid =id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}
	
	@Column(name = "CompetetionId")
	public int getCompetetionid() {
		return competetionid;
	}

	public void setCompetetionid(int competetionid) {
		this.competetionid = competetionid;
	}

	@Column(name = "FieldType")
	public String getFieldtype() {
		return fieldtype;
	}

	public void setFieldtype(String fieldtype) {
		this.fieldtype = fieldtype;
	}

	@Column(name = "FieldName")
	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	@Column(name = "FieldId")
	public String getFieldid() {
		return fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	@Column(name = "UserMapping")
	public String getUserData() {
		return userData;
	}

	public void setUserData(String userData) {
		this.userData = userData;
	}

	public CompetetionEntity(int competetionid, String fieldtype, String fieldname, String fieldid, String userData) {
		super();
		this.competetionid = competetionid;
		this.fieldtype = fieldtype;
		this.fieldname = fieldname;
		this.fieldid = fieldid;
		this.userData = userData;
	}

	@Override
	public String toString() {
		return "CompetetionEntity [competetionid=" + competetionid + ", fieldtype=" + fieldtype + ", fieldname="
				+ fieldname + ", fieldid=" + fieldid + ", userData=" + userData + "]";
	}

}
