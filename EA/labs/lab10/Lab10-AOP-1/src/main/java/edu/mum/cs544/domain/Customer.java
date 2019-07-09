package edu.mum.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

}
