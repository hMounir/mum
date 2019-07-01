package edu.mum.cs544;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    private String appdate;
    @Embedded
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient")
    private Patient patient;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    public Appointment(String appdate, Payment payment, Patient patient, Doctor doctor) {
        this.appdate = appdate;
        this.payment = payment;
        this.patient = patient;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appdate='" + appdate + '\'' +
                ", payment=" + payment +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
