package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movie {

	@Id
	@Column(name="m_id")
	private Integer id;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + "]";
	}

	
}
