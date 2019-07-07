package edu.mum.cs544.bank.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountEntry {

    @Id
    @GeneratedValue
    private Integer id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private double amount;
    private String description;
    private String fromAccountNumber;
    private String fromPersonName;

    public AccountEntry(Date date, double amount, String description, String fromAccountNumber, String fromPersonName) {
        super();
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.fromAccountNumber = fromAccountNumber;
        this.fromPersonName = fromPersonName;
    }

}
