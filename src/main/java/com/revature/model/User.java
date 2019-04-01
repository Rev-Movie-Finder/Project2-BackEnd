package com.revature.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class User implements Serializable {

	
	//https://api.themoviedb.org/3/movie/550?api_key=2b044ada4c06adcd1cca7f4c9f14ffa9
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="u_id")
	@SequenceGenerator(sequenceName="user_seq", name="u_seq")
	@GeneratedValue(generator="u_seq", strategy=GenerationType.SEQUENCE)
    private int userId;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="username", unique = true)
      private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="avatar")
	private String avatar;
	
	@Column(name="email")
	private String email;

	
	@Column(name="birthday")
	private Date birthday;

	
	@Column(name="gender")
	@Enumerated(EnumType.ORDINAL)
	private Gender Gender;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name="user_favorite_JT", joinColumns=@JoinColumn(name="u_id"), inverseJoinColumns=@JoinColumn(name="f_id"))
	private List<Favorites> favs = new ArrayList<Favorites>();

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public Gender getGender() {
		return Gender;
	}


	public void setGender(Gender gender) {
		Gender = gender;
	}

    @ManyToMany
     @JoinTable(name="JOIN_USER_FAVORITES",
     joinColumns= {@JoinColumn(name="userId")},inverseJoinColumns= {@JoinColumn(name="favId")})
	public List<Favorites> getFavs() {
		return favs;
	}


	public void setFavs(List<Favorites> favs) {
		this.favs = favs;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favs == null) ? 0 : favs.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Gender != other.Gender)
			return false;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favs == null) {
			if (other.favs != null)
				return false;
		} else if (!favs.equals(other.favs))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", avatar=" + avatar + ", email=" + email + ", birthday="
				+ birthday + ", Gender=" + Gender + ", favs=" + favs + "]";
	}
	 
	 
	//private ArrayList<Favorites> favs = new ArrayList<Favorites>();


	
	
	
}
