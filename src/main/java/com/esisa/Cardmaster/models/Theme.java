package com.esisa.Cardmaster.models;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "theme")
public class Theme{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	@Column(name = "img")
	private String img;
	@Column(name = "path")
	private String path;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Theme [id=" + id + ", img=" + img + ", path=" + path + "]";
	}
	
	
}