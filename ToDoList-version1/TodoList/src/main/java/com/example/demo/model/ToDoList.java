package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todolist")
public class ToDoList implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
	
	@Column(name = "ghi_chu", nullable = false)
	private String ghi_chu;
	
	@Column(name = "ngay_thang")
	private String ngay_thang;
	
	@Column(name = "noi_dung")
	private String noi_dung;

	public ToDoList() {
		super();
	}

	public ToDoList(long id, String ghi_chu, String ngay_thang, String noi_dung) {
		super();
		this.id = id;
		this.ghi_chu = ghi_chu;
		this.ngay_thang = ngay_thang;
		this.noi_dung = noi_dung;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGhi_chu() {
		return ghi_chu;
	}

	public void setGhi_chu(String ghi_chu) {
		this.ghi_chu = ghi_chu;
	}

	public String getNgay_thang() {
		return ngay_thang;
	}

	public void setNgay_thang(String ngay_thang) {
		this.ngay_thang = ngay_thang;
	}

	public String getNoi_dung() {
		return noi_dung;
	}

	public void setNoi_dung(String noi_dung) {
		this.noi_dung = noi_dung;
	}
	
	
	


}
