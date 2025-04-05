



// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// //  import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.model.Booking;
// import com.example.demo.service.BookingService;

// @RestController
// @RequestMapping("/bookings")
// public class BookingController {

//     private final BookingService bookingService;

//     public BookingController(BookingService bookingService) {
//         this.bookingService = bookingService;
//     }

//     @PostMapping
//     public Booking createBooking(@RequestBody Booking booking) {
//         return bookingService.createBooking(booking);
//     }

//     @PostMapping("/bulk")
//     public List<Booking> createMultipleBookings(@RequestBody List<Booking> bookings) {
//         return bookingService.createMultipleBookings(bookings);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
//         return ResponseEntity.ok(bookingService.getBookingById(id));
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
//         return ResponseEntity.ok(bookingService.updateBooking(id, booking));
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
//         bookingService.deleteBooking(id);
//         return ResponseEntity.noContent().build();
//     }
    
   
    


//     // ✅ Updated to support Pagination and Sorting
//     @GetMapping
//     public ResponseEntity<Page<Booking>> getAllBookings(Pageable pageable) {
//         return ResponseEntity.ok(bookingService.getAllBookings(pageable));
//     }
// }



package com.example.demo.controller;

import java.util.List;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Booking>> createMultipleBookings(@RequestBody List<Booking> bookings) {
        return ResponseEntity.ok(bookingService.createMultipleBookings(bookings));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.updateBooking(id, booking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Fetch paginated bookings
    // @GetMapping
    // public ResponseEntity<Page<Booking>> getAllBookings(Pageable pageable) {
    //     return ResponseEntity.ok(bookingService.getAllBookings(pageable));
    // }



    @GetMapping ("/getAll")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
    


    // ✅ Fetch all bookings for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
    }

    // ✅ Create a booking for a specific user
    @PostMapping("/user/{userId}")
    public ResponseEntity<Booking> createBookingForUser(@PathVariable Long userId, @RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBookingForUser(userId, booking));
    }
}
