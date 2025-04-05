
//using pagination and sorting and custom jpa
package com.example.demo.controller;

// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/users")
// public class UserController {

//     @Autowired
//     private UserService userService;

//     // Create User (Single or Multiple) give as list
//     @PostMapping
//     public List<User> createUsers(@RequestBody List<User> users) {
//         return userService.saveUsers(users);
//     }

//     // Get All Users
//     @GetMapping
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     // Get User by ID
//     @GetMapping("/{id}")
//     public Optional<User> getUserById(@PathVariable Long id) {
//         return userService.getUserById(id);
//     }

//     // Update User
//     @PutMapping("/{id}")
//     public User updateUser(@PathVariable Long id, @RequestBody User user) {
//         return userService.updateUser(id, user);
//     }

//     // Delete User
//     @DeleteMapping("/{id}")
//     public String deleteUser(@PathVariable Long id) {
//         return userService.deleteUser(id) ? "User deleted" : "User not found";
//     }
// }






import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create Users (Single or Multiple)
    @PostMapping
    public List<User> createUsers(@RequestBody List<User> users) {
        return userService.saveUsers(users);
    }

    // Get All Users with Pagination & Sorting
    @GetMapping
    public Page<User> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete User
    // @DeleteMapping("/{id}")
    // public String deleteUser(@PathVariable Long id) {
    //     return userService.deleteUser(id) ? "User deleted" : "User not found";
    // }
    @DeleteMapping("/{id}")
public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    return userService.deleteUser(id) 
        ? ResponseEntity.ok("User with ID " + id + " has been successfully deleted.") 
        : ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " not found.");
}

}
