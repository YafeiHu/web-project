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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="country")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID",unique=true,nullable=false)
	private Integer id;
	
	@NotEmpty
	@Size(min=1, max=20)
	@Column(name="COUNTRY_NAME",unique=true,nullable=false)
	private String countryname;
	
	@Column
	private String passport;
	
	@Column
	private String description;
	
	@Column
	private String sign;
	
	@Column
	private String consumption;
	
	@Column
	private String currency;
	
	@Column
	private String emergency;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="CONTINENT_ID")
	private Continent continent;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="country",cascade=CascadeType.ALL)
	private Set<City> citys;
	
	@OneToOne(fetch=FetchType.LAZY,mappedBy="country",cascade=CascadeType.ALL)
	private CountryPhoto photo;
	
	
	public Country(){
		citys=new HashSet<City>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public Set<City> getCitys() {
		return citys;
	}

	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public CountryPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(CountryPhoto photo) {
		this.photo = photo;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getConsumption() {
		return consumption;
	}

	public void setConsumption(String consumption) {
		this.consumption = consumption;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEmergency() {
		return emergency;
	}

	public void setEmergency(String emergency) {
		this.emergency = emergency;
	}

	
	
	
	
}
