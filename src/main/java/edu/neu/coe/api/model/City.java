package edu.neu.coe.api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CITY_ID",unique=true,nullable=false)
	private Integer id;
	
	@NotEmpty
	@Size(min=1, max=20)
	@Column(name="CITY_NAME",unique=true,nullable=false)
	private String cityname;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="COUNTRY_ID")
	private Country country;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="city")
	private Set<Sight> sights;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="city")
	private Set<Food> foods;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="city",cascade=CascadeType.ALL)
	private Set<CityPhoto> photos=new HashSet<CityPhoto>();
	
	
	@Column
	private Integer coverphoto;
	
	@Column
	private String weather;
	
	@Column
	private String tax;
	
	@Column
	private String life;
	
	public City(){
		sights=new HashSet<Sight>();
		foods=new HashSet<Food>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	
	public Set<Sight> getSights() {
		return sights;
	}

	public void setSights(Set<Sight> sights) {
		this.sights = sights;
	}

	public Set<Food> getFoods() {
		return foods;
	}

	public void setFoods(Set<Food> foods) {
		this.foods = foods;
	}

	public Integer getCoverphoto() {
		return coverphoto;
	}

	
	public void setCoverphoto(Integer coverphoto) {
		this.coverphoto = coverphoto;
	}

	public Set<CityPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<CityPhoto> photos) {
		this.photos = photos;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getLife() {
		return life;
	}

	public void setLife(String life) {
		this.life = life;
	}
	
	
	
}
