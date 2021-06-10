package com.esisa.Cardmaster.models;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private  int id;

	public JwtResponse(String jwttoken,int id) {
		this.jwttoken = jwttoken;
		this.setId(id);
	}

	public String getToken() {
		return this.jwttoken;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}