package org.bigxp.bigxp.Controller;

import org.bigxp.bigxp.Model.Booking;
import org.bigxp.bigxp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
// oprette booking(eksterne system fordi kunder skal oprette bookingen)
//se alle booking(intern system personale da de skal administrer det)
//redigere booking(intern system personale da de skal administrer det)
//slet booking(intern system personale da de skal administrer det)
//Bushra laver det
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/booking")
public class BookingRestController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> allBookings() {
        return new ResponseEntity<List<Booking>>(bookingRepository.findAll(), HttpStatus.OK);
    }


}
