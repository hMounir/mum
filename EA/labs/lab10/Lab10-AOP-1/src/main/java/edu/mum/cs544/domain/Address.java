package edu.mum.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue
	private Integer id;

	private String street;
	private String city;
	private String zip;

	public Address(String street, String city, String zip) {
		super();
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

}
