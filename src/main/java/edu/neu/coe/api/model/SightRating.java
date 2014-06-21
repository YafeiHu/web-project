package edu.neu.coe.api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="sightrating")
public class SightRating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SIGHTRATING_ID",unique=true,nullable=false)
	private Integer id;
	
	@Column(name="SIGHTRATING_CONTENT",unique=true,nullable=false)
	private String content;
	
	@Column(name="SIGHTRATING_DATE",unique=true,nullable=false)
	private Date date;
	
	@Column(name="SIGHTRATING_RATING",unique=true,nullable=false)
	private Integer rating;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID", nullable=false)
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="SIGHT_ID", nullable=false)
	private Sight sight;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Sight getSight() {
		return sight;
	}
	public void setSight(Sight sight) {
		this.sight = sight;
	}
	
	
}
