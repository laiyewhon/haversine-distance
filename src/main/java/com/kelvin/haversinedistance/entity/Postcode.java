package com.kelvin.haversinedistance.entity;

import org.springframework.data.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "postcodelatlng")
public class Postcode {
    @Version
    @Id
    private Long id;

    @Column
    private String postcode;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postcode postcodes = (Postcode) o;
        return Objects.equals(id, postcodes.id) && Objects.equals(postcode, postcodes.postcode) && Objects.equals(latitude, postcodes.latitude) && Objects.equals(longitude, postcodes.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postcode, latitude, longitude);
    }
}
