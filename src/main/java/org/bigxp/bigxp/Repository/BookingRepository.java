package org.bigxp.bigxp.Repository;


import org.bigxp.bigxp.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
