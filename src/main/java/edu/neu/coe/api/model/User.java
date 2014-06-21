package edu.neu.coe.api.model;

import java.sql.Blob;
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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID",unique=true,nullable=false)
	private Integer id;
	
	@Column(name="USER_NAME",unique=true,nullable=false,length=20)
	@NotEmpty
	@Size(min=1, max=30)
	private String name;
	
	@Column(name="PASSWORD",nullable=false,length=20)
	@NotEmpty
	@Size(min=1, max=20)
	private String password;
	
	@Column(name="EMAIL",unique=true,nullable=false,length=30)
	private String email;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user",cascade=CascadeType.ALL)
	private Set<SightRating> sight_ratings;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user",cascade=CascadeType.ALL)
	private Set<FoodRating> food_ratings;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="user_role",
	joinColumns={@JoinColumn(name="USER_ID",updatable=false)},
	inverseJoinColumns={@JoinColumn(name="ROLE_ID",updatable=false)})
	private Set<Role> roles;
	
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user",cascade=CascadeType.ALL)
	private Set<Photo> photos=new HashSet<Photo>();
	
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="owner",cascade=CascadeType.ALL)
	//@JoinColumn(name="PHOTO")
	private UserPhoto photo;
	
	
	
	public User() {
		sight_ratings=new HashSet<SightRating>();
		food_ratings=new HashSet<FoodRating>();
		roles=new HashSet<Role>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Set<SightRating> getSight_ratings() {
		return sight_ratings;
	}
	public void setSight_ratings(Set<SightRating> sight_ratings) {
		this.sight_ratings = sight_ratings;
	}
	public Set<FoodRating> getFood_ratings() {
		return food_ratings;
	}
	public void setFood_ratings(Set<FoodRating> food_ratings) {
		this.food_ratings = food_ratings;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public UserPhoto getPhoto() {
		return photo;
	}
	public void setPhoto(UserPhoto photo) {
		this.photo = photo;
	}
	public Set<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	
	

}
