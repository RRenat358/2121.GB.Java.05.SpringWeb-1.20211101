package ru.rrenat358.composed_key;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passports")
public class Passport {
    @EmbeddedId
    private SerialAndNumber id;

    @Column(name = "registration_address")
    private String registrationAddress;

    public SerialAndNumber getId() {
        return id;
    }

    public void setId(SerialAndNumber id) {
        this.id = id;
    }

    public String getRegistrationAddress() {
        return registrationAddress;
    }

    public void setRegistrationAddress(String registrationAddress) {
        this.registrationAddress = registrationAddress;
    }

    public Passport() {
    }

    @Override
    public String toString() {
        return String.format("Passport [serial = %d, number = %d, registration = %s]", id.getSerial(), id.getNumber(), registrationAddress);
    }
}
