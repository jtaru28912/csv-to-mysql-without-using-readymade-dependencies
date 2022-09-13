package com.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FileEntity") // table name = FileEntity
public class FileEntity {
	// fid is the primary key
	@Id
	@GeneratedValue
	private int fId;
	private String fName;
	private String noOfRecords;
	private String insertCount;
	private String createDate;
	private String updatedDate;

	// parameterized constructor
	public FileEntity(int fId, String fName, String noOfRecords, String insertCount, String createDate,
			String updatedDate) {
		super();
		this.fId = fId;
		this.fName = fName;
		this.noOfRecords = noOfRecords;
		this.insertCount = insertCount;
		this.createDate = createDate;
		this.updatedDate = updatedDate;
	}

	// default constructor
	public FileEntity() {
		super();
	}

	// getter and setters methods
	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getNoOfRecords() {
		return noOfRecords;
	}

	public void setNoOfRecords(String noOfRecords) {
		this.noOfRecords = noOfRecords;
	}

	public String getInsertCount() {
		return insertCount;
	}

	public void setInsertCount(String insertCount) {
		this.insertCount = insertCount;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
