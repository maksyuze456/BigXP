package org.bigxp.bigxp.Controller;

import org.bigxp.bigxp.Model.Booking;
import org.bigxp.bigxp.Repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingRestController {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingRestController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Hent alle bookinger
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Hent én booking efter ID
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") int id) {
        Optional<Booking> opt = bookingRepository.findById(id);
        return opt
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Opret en ny booking
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking saved = bookingRepository.save(booking);
        // Returnér 201 Created + Location-header
        return ResponseEntity
                .created(URI.create("/bookings/" + saved.getBookingId()))
                .body(saved);
    }

    // Opdater en eksisterende booking
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable("id") int id,
            @RequestBody Booking booking) {

        if (!bookingRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        // Sørg for at path ID og body ID stemmer overens
        booking.setBookingId(id);
        Booking updated = bookingRepository.save(booking);
        return ResponseEntity.ok(updated);
    }

    // Slet en booking
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") int id) {
        if (!bookingRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        bookingRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
