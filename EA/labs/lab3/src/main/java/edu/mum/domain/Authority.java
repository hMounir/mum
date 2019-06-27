package edu.mum.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "authority")
public class Authority {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", nullable = false)
 	private long id;

	@Column(name = "username")
	private String username;

	@Column(name = "authority", nullable = false)
 	private String authority;
 	
}
