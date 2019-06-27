package edu.mum.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "authentication")
public class UserCredentials implements Serializable {

	@Id
	@Column(name = "USER", nullable = false, length = 127)
  	private String username;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "PASSWORD", nullable = false, length = 32)
	private String password;

	@Column(name = "VERIFYPASSWORD")
	private String verifyPassword;


 	
}
