package edu.neu.coe.api.model;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="food")
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="FOOD_ID",unique=true,nullable=false)
	private Integer id;
	
	@NotEmpty
	@Size(min=1, max=20)
	@Column(name="Food_NAME",unique=true,nullable=false)
	private String foodname;
	
	
	@Column(name="DESCRIPTION",length=500)
	private String description;
	
	@Column(name="ADDRESS",length=50)
	private String address;
	
	@Column(name="PATH",length=50)
	private String path;
	
	@Column(name="WORKTIME",length=30)
	private String worktime;
	
	@Column(name="URL",length=20)
	private String url;
	
	@Column(name="PHONE",length=20)
	private String phone;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CITY_ID",nullable=false)
	private City city;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="food",cascade=CascadeType.ALL)
	private Set<FoodRating> food_ratings;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="food",cascade=CascadeType.ALL)
	private Set<FoodPhoto> photos=new HashSet<FoodPhoto>();
	
	@Column
	private Integer coverphoto;
	
	public Food() {
		food_ratings=new HashSet<FoodRating>();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getFoodname() {
		return foodname;
	}
	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}
	public Set<FoodRating> getFood_ratings() {
		return food_ratings;
	}
	public void setFood_ratings(Set<FoodRating> food_ratings) {
		this.food_ratings = food_ratings;
	}
	public Integer getCoverphoto() {
		return coverphoto;
	}
	public void setCoverphoto(Integer coverphoto) {
		this.coverphoto = coverphoto;
	}
	public Set<FoodPhoto> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<FoodPhoto> photos) {
		this.photos = photos;
	}
	
	
	
	
	
}
