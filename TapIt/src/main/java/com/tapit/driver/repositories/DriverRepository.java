
package com.tapit.driver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tapit.driver.models.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

}
