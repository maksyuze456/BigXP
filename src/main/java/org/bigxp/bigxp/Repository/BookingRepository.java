package org.bigxp.bigxp.Repository;


import org.bigxp.bigxp.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    //List<Booking> getAllByBookingId(int bookingId);
    //List<Booking>findBookingDate(LocalDate bookinDate);
    //List<Booking>findByPhone(String Phone);
}
