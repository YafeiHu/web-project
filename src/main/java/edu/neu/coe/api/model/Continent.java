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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="continent")
public class Continent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CONTINENT_ID",unique=true,nullable=false)
	private Integer id;
	
	@NotEmpty
	@Size(min=1, max=20)
	@Column(name="CONTINENT_NAME",unique=true,nullable=false)
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="continent",cascade=CascadeType.ALL)
	private Set<Country> countrys=new HashSet<Country>();
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Country> getCountrys() {
		return countrys;
	}

	public void setCountrys(Set<Country> countrys) {
		this.countrys = countrys;
	}

	
	
	
	
}
