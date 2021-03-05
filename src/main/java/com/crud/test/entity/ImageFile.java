package com.crud.test.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String fileName;

	private String fileType;


	@OneToOne(mappedBy = "userProfilePic")
	@JsonIgnore
	private User user;

//
//	@Lob
//	private byte[] data;

	public ImageFile() {

	}

	public ImageFile(String fileName, String fileType) {
		this.fileName = fileName;
		this.fileType = fileType;

	}

	public String getId() {
		return id;
	}

	public String getFileName() {
		return fileName;
	}

	public String getFileType() {
		return fileType;
	}



	public void setId(String id) {
		this.id = id;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}




	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
