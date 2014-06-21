package edu.neu.coe.api.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="sightphoto")
@PrimaryKeyJoinColumn(name="PHOTO_ID")
public class SightPhoto extends Photo{

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="OWNER_ID",nullable=false)
	private Sight sight;

	public Sight getSight() {
		return sight;
	}

	public void setSight(Sight sight) {
		this.sight = sight;
	}

	
	
	
}
