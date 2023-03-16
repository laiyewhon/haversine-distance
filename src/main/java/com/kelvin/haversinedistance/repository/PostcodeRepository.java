package com.kelvin.haversinedistance.repository;

import com.kelvin.haversinedistance.entity.Postcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostcodeRepository extends CrudRepository<Postcode, Long> {
    Optional<Postcode> findByPostcode(String postcode);
}
