package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Payment {

    private String paydate;
    private double amount;

    public Payment(String paydate, double amount) {
        this.paydate = paydate;
        this.amount = amount;
    }
}
