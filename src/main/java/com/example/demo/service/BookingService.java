//  package com.example.demo.service;








// import org.springdoc.core.converters.models.Pageable;
// import org.springframework.data.domain.Page;

// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import com.example.demo.model.Booking;
// import com.example.demo.repository.BookingRepository;
// import java.util.List;

// @Service
// public class BookingService {
//     private final BookingRepository bookingRepository;

//     public BookingService(BookingRepository bookingRepository) {
//         this.bookingRepository = bookingRepository;
//     }

//     public Booking createBooking(Booking booking) {
//         return bookingRepository.save(booking);
//     }

//     @Transactional
//     public List<Booking> createMultipleBookings(List<Booking> bookings) {
//         return bookingRepository.saveAll(bookings);
//     }

//     public Booking getBookingById(Long id) {
//         return bookingRepository.findById(id).orElse(null);
//     }

//     public Booking updateBooking(Long id, Booking booking) {
//         booking.setId(id);
//         return bookingRepository.save(booking);
//     }

//     public void deleteBooking(Long id) {
//         bookingRepository.deleteById(id);
//     }

//     public List<Booking> getAllBookings() {
//         return bookingRepository.findAll();
//     }
// }




// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import com.example.demo.model.Booking;
// import com.example.demo.repository.BookingRepository;
// import java.util.List;

// @Service
// public class BookingService {
//     private final BookingRepository bookingRepository;

//     public BookingService(BookingRepository bookingRepository) {
//         this.bookingRepository = bookingRepository;
//     }

//     public Booking createBooking(Booking booking) {
//         return bookingRepository.save(booking);
//     }

//     @Transactional
//     public List<Booking> createMultipleBookings(List<Booking> bookings) {
//         return bookingRepository.saveAll(bookings);
//     }

//     public Booking getBookingById(Long id) {
//         return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
//     }

//     public Booking updateBooking(Long id, Booking booking) {
//         if (!bookingRepository.existsById(id)) {
//             throw new RuntimeException("Booking not found");
//         }
//         booking.setId(id);
//         return bookingRepository.save(booking);
//     }

//     public void deleteBooking(Long id) {
//         if (!bookingRepository.existsById(id)) {
//             throw new RuntimeException("Booking not found");
//         }
//         bookingRepository.deleteById(id);
//     }

//     // ✅ Updated method to support Pagination & Sorting
//     public Page<Booking> getAllBookings(Pageable pageable) {
//         return bookingRepository.findAll(pageable);
//     }
// }





package com.example.demo.service;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository; // Needed for user-booking mapping

    public BookingService(BookingRepository bookingRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Transactional
    public List<Booking> createMultipleBookings(List<Booking> bookings) {
        return bookingRepository.saveAll(bookings);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public Booking updateBooking(Long id, Booking booking) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        bookingRepository.deleteById(id);
    }

    // ✅ Fetch all bookings with pagination
    // public Page<Booking> getAllBookings(Pageable pageable) {
    //     return bookingRepository.findAll(pageable);
    // }

    // ✅ Fetch all bookings for a specific user
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    // ✅ Create a booking for a specific user
    public Booking createBookingForUser(Long userId, Booking booking) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);
        return bookingRepository.save(booking);
    }
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
    
}
