package edu.neu.coe.api.model;

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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="sight")
public class Sight {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIGHT_ID",unique=true,nullable=false)
	private Integer id;
	
	@NotEmpty
	@Size(min=1, max=20)
	@Column(name="SIGHT_NAME",unique=true,nullable=false)
	private String sightname;
	
	@Column(name="DESCRIPTION",length=500)
	private String description;
	
	@Column(name="ADDRESS",length=100)
	private String address;
	
	@Column(name="PATH",length=100)
	private String path;
	
	@Column(name="WORKTIME",length=100)
	private String worktime;
	
	@Column(name="URL",length=100)
	private String url;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CITY_ID",nullable=false)
	private City city;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sight",cascade=CascadeType.ALL)
	private Set<SightRating> sight_ratings;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sight",cascade=CascadeType.ALL)
	private Set<SightPhoto> photos=new HashSet<SightPhoto>();
	
	@Column
	private Integer coverphoto;
	
	public Sight() {
		sight_ratings=new HashSet<SightRating>();
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getSightname() {
		return sightname;
	}
	public void setSightname(String sightname) {
		this.sightname = sightname;
	}
	public Set<SightRating> getSight_ratings() {
		return sight_ratings;
	}
	public void setSight_ratings(Set<SightRating> sight_ratings) {
		this.sight_ratings = sight_ratings;
	}
	public Integer getCoverphoto() {
		return coverphoto;
	}
	public void setCoverphoto(Integer coverphoto) {
		this.coverphoto = coverphoto;
	}
	public Set<SightPhoto> getPhotos() {
		return photos;
	}
	public void setPhotos(Set<SightPhoto> photos) {
		this.photos = photos;
	}
	
	
	
	
	
}
