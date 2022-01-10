package com.example.user.controller;


import com.example.user.exception.ResourceNotFoundException;
import com.example.user.model.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean isSuccess = userService.createUser(user);
        if (isSuccess) {
            return new ResponseEntity<String>("User has been created.", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("User creation failed.", HttpStatus.BAD_REQUEST);

    }
    @GetMapping
    public ResponseEntity<?> findAllUser() {
       return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") int userId)
            throws ResourceNotFoundException {
        User user = userService.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

        @PutMapping
        public ResponseEntity<?> updateUser(@RequestBody User user) {
            boolean isSuccess = userService.updateUser(user);
            if (isSuccess) {
                return new ResponseEntity<String>("User details has been updated.", HttpStatus.OK);
            }
            return new ResponseEntity<String>("User updating failed.", HttpStatus.BAD_REQUEST);
        }

        @DeleteMapping
        public ResponseEntity<?> deleteUser(@RequestBody User user) {
            userService.deleteUser(user);
            return new ResponseEntity<String>("User has been deleted.", HttpStatus.OK);
        }

}
