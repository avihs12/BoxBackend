package com.boxproject.backend.Controller;

import com.boxproject.backend.Entities.Activity;

import com.boxproject.backend.Entities.ActivityRequest;
import com.boxproject.backend.Entities.Slots;
import com.boxproject.backend.Entities.Userr;
import com.boxproject.backend.Entities.UserRequest;
import com.boxproject.backend.Exceptions.ActivityNotFoundException;
import com.boxproject.backend.Exceptions.UsernameAlreadyExistException;
import com.boxproject.backend.Services.ActivityService;
import com.boxproject.backend.Services.SlotsService;
import com.boxproject.backend.Services.UserService;
import com.boxproject.backend.security.AuthRequest;
import com.boxproject.backend.security.JwtResponse;
import com.boxproject.backend.security.JwtUtils;

//import com.boxproject.backend.security.JwtResponse;
//import com.boxproject.backend.security.JwtUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    
    @Autowired
    private ActivityService activityService;
    @Autowired
    private SlotsService slotsService;
    @Autowired
    private UserService userservice;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils Jwtutils;

    @GetMapping("/getactivities")
    public ResponseEntity<List<Activity>> findallActivity() {
        List<Activity> activityList = activityService.getall();
        return new ResponseEntity<>(activityList, HttpStatus.OK);
    }

    @GetMapping("/getusernames")
    public ResponseEntity<List<String>> findAllusernames() {
        List<String> List = userservice.getAllUsernames();
        return new ResponseEntity<>(List, HttpStatus.OK);
    }

    @GetMapping("/getactivity/{id}")
    public ResponseEntity<Optional<Activity>> findactivityById(@PathVariable Integer id)
            throws ActivityNotFoundException {
        Optional<Activity> activity = activityService.getBYId(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @GetMapping("/getslots")
    public ResponseEntity<List<Slots>> findallTimeSlot() {
        List<Slots> slotsList = slotsService.findallslots();
        return new ResponseEntity<>(slotsList, HttpStatus.OK);
    }

    @GetMapping("/getcities")
    public ResponseEntity<List<String>> findallcitiest() {
        List<String> listofCities = activityService.getallcities();
        return new ResponseEntity<>(listofCities, HttpStatus.OK);
    }

    @GetMapping("/getactivitiesbycity/{cityname}")
    public ResponseEntity<List<Activity>> findactivitiesByCityName(@PathVariable String cityname)
            throws ActivityNotFoundException {
        List<Activity> activityList = activityService.findBycityname(cityname);
        return new ResponseEntity<>(activityList, HttpStatus.OK);
    }

      @GetMapping("/getusers")
    public ResponseEntity<List<Userr>> findallusers() {
        List<Userr> userlist = userservice.getall();
        return new ResponseEntity<>(userlist, HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<Activity> saveActivity(@RequestBody @Valid ActivityRequest acti) {
        Activity activity = activityService.saveActivity(acti);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PostMapping("/postt")
    public ResponseEntity<Userr> saveActivity(@RequestBody @Valid UserRequest activ)
            throws UsernameAlreadyExistException {
        activ.setPassword(userservice.encodePassword(activ.getPassword()));
        Userr userr = userservice.saveActivity(activ);
        return new ResponseEntity<>(userr, HttpStatus.OK);
    }

    @PostMapping("/edituser")
    public ResponseEntity<Userr> editActivity(@RequestBody Userr user) throws ActivityNotFoundException {
        Userr act = userservice.editActivity(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/editactivity")
    public ResponseEntity<Activity> editActivity(@RequestBody Activity activity) throws ActivityNotFoundException {
        Activity act = activityService.editActivity(activity);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteActivtiyUser(@PathVariable Integer id) throws ActivityNotFoundException {
        String message = userservice.deleteUserById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/deleteActivity/{id}")
    public ResponseEntity<String> deleteActivtiy(@PathVariable Integer id) throws ActivityNotFoundException {
        String message = activityService.deleteActivityById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("Entry into authenticate endpoint");
        System.out.println("Username: " + authRequest.getUsername());
        System.out.println("Password: " + authRequest.getPassword());

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println("Authentication process completed");

            if (authentication.isAuthenticated()) {
                System.out.println("Authentication successful");
                JwtResponse resp = Jwtutils.createJwtToken(authRequest);
                System.out.println("JWT created successfully");

                return new ResponseEntity<>(resp, HttpStatus.OK);
            } else {
                System.out.println("Authentication failed");
                throw new UsernameNotFoundException("User not found");
            }
        } catch (Exception e) {
            System.err.println("Authentication exception: " + e.getMessage());
            e.printStackTrace();
            throw e; // Re-throw the exception to handle it properly
        }
    }
}

// INput be like in post man
// {
// "activity_name": "cricket", //not null
// "activity_city": "Hyderabad", //not null
// "activity_address": "opp paradise secundrabad", //not null
// "activity_state": "Telangana", //not null
// "activity_price": 350, //min 150 to max 400
// "activity_rating": 4, //min 1 to max 5
// "activity_owner_name": "Sreenath", //not null
// "activity_ownwer_mobile": 8142872949, //not null
// "activity_owner_address": "11/7g tolichowki hyderabad", //not null
// "slots": [ //no validations
// {
// "slot_time": "10 AM",
// "slot_status_Available_Today":"no",
// "slot_status_Available_Tomorrow":"no"
// },
// {
// "slot_time": "12 PM",
// "slot_status_Available_Today":"yes",
// "slot_status_Available_Tomorrow":"yes"
// },
// {
// "slot_time": "2 PM",
// "slot_status_Available_Today":"yes",
// "slot_status_Available_Tomorrow":"yes"
// },
// {
// "slot_time": "4 PM",
// "slot_status_Available_Today":"no",
// "slot_status_Available_Tomorrow":"no"
// }
// ]
// }
// }

// }
