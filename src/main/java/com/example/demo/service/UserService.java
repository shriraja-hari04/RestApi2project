
//using pagination and sorting and custom jpa
package com.example.demo.service;

// package com.example.demo.service;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class UserService {

//     @Autowired
//     private UserRepository userRepository;

//     // Save multiple users
//     public List<User> saveUsers(List<User> users) {
//         return userRepository.saveAll(users);
//     }

//     // Get all users
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }

//     // Get user by ID
//     public Optional<User> getUserById(Long id) {
//         return userRepository.findById(id);
//     }

//     // Update user
//     public User updateUser(Long id, User userDetails) {
//         return userRepository.findById(id).map(user -> {
//             user.setFirstName(userDetails.getFirstName());
//             user.setLastName(userDetails.getLastName());
//             user.setEmail(userDetails.getEmail());
//             user.setPhoneNumber(userDetails.getPhoneNumber());
//             return userRepository.save(user);
//         }).orElseThrow(() -> new RuntimeException("User not found"));
//     }

//     // Delete user
//     public boolean deleteUser(Long id) {
//         if (userRepository.existsById(id)) {
//             userRepository.deleteById(id);
//             return true;
//         }
//         return false;
//     }
// }





import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save Users
    public List<User> saveUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    // Get All Users with Pagination & Sorting
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    // Get User by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update User
    public User updateUser(Long id, User user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            return userRepository.save(existingUser);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete User
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
