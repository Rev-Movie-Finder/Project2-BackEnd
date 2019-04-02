package com.revature.model;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@Column(name="u_id")
	@SequenceGenerator(sequenceName="user_seq", name="u_seq")
	@GeneratedValue(generator="u_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(name="u_email")
	private String email;
	@Column(name="u_username", unique=true)
	private String username;
	@Column(name="u_password")
	private String password;
	@Column(name="u_birthday")
	private Date birthday;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="user_favorite_jt", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="m_id"))
	private Set<Movie> favoriteMovies;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.PERSIST)
	@JoinTable(name="user_wish_jt", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="m_id"))
	private Set<Movie> wishList;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.birthday = null;
		this.favoriteMovies = new HashSet<Movie>();
		this.wishList = new HashSet<Movie>();
	}
	
	public User(String email, String username, String password, Date birthday, Set<Movie> favoriteMovies,
			Set<Movie> wishList) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.favoriteMovies = favoriteMovies;
		this.wishList = wishList;
	}

	public User(Integer id, String email, String username, String password, Date birthday, Set<Movie> favoriteMovies,
			Set<Movie> wishList) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.favoriteMovies = favoriteMovies;
		this.wishList = wishList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set<Movie> getFavoriteMovies() {
		return favoriteMovies;
	}

	public void setFavoriteMovies(Set<Movie> favoriteMovies) {
		this.favoriteMovies = favoriteMovies;
	}
	
	public void addFavoriteMovies(Movie movie) {
		this.favoriteMovies.add(movie);
	}

	public Set<Movie> getWishList() {
		return wishList;
	}

	public void setWishList(Set<Movie> wishList) {
		this.wishList = wishList;
	}
	
	public void addWishList(Movie movie) {
		this.wishList.add(movie);
	}
	


	
}
