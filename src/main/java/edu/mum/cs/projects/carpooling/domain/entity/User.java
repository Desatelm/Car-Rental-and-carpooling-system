package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "email", unique = true)
	private String emailAddress;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "sex")
	private String sex;

	@Column(name = "active")
	private int active;

	@Column(name = "phone_no", unique = true)
	private String phone;

	@Column(name = "date_of_birth")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Lob
	@Column(name = "picture")

	private Boolean[] profilePicture;

	@Column(name = "password")
	private String password;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	@Embedded
	private Address address;

	@Embedded
	private Rating rating;

	@OneToMany(cascade = CascadeType.ALL)
	private List<MessageBox> messageBox;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "user")
	private List<Ride> ride = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Role roles;

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<MessageBox> getMessageBox() {
		return messageBox;
	}

	public void setMessageBox(List<MessageBox> messageBox) {
		this.messageBox = messageBox;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public User() {

	}

	public User(User user) {
		this.id = user.id;
		this.active = user.getActive();
		this.address = user.getAddress();
		this.dateOfBirth = user.getDOB();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.messageBox = user.getMessageBox();
		this.emailAddress = user.getEmailAddress();
		this.password = user.getPassword();
		this.phone = user.getPhone();
		this.rating = user.getRating();
		this.ride = user.getRide();
		this.sex = user.getSex();
		this.roles = user.getRoles();
		this.vehicles = user.getVehicles();
	}

	private Rating getRating() {
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getSex() {
		return sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDOB() {
		return dateOfBirth;
	}

	public void setDOB(Date dOB) {
		dateOfBirth = dOB;
	}

	public Boolean[] getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Boolean[] profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ride> getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride.add(ride);
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

}
