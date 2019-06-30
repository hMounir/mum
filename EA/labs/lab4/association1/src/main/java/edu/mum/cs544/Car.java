package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Car {
	@Id
	@GeneratedValue
	private long id;
	private String brand;
	private String year;
	private double price;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ownerId",referencedColumnName = "id",nullable = false)
	private Owner owner;



	public Car(String brand, String year, double price, Owner owner) {
		this.brand = brand;
		this.year = year;
		this.price = price;
		this.owner = owner;
	}
}
