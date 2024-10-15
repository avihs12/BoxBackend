package com.boxproject.backend.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.boxproject.backend.Entities.Userr;
import com.boxproject.backend.Exceptions.ActivityNotFoundException;
import com.boxproject.backend.Exceptions.UsernameAlreadyExistException;
import com.boxproject.backend.Entities.Activity;
import com.boxproject.backend.Entities.UserRequest;
import com.boxproject.backend.Repos.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Userr saveActivity(UserRequest userReq) throws UsernameAlreadyExistException {

       
        List<String> existingUsernames = userRepository.getUsernames();

        if (existingUsernames.contains(userReq.getUsername())) {
            System.out.println(userReq.getUsername() + "dfghyjkvc");
            throw new UsernameAlreadyExistException("Username already exists");
        }
        Userr user = new Userr(
                userReq.getUserid(),
                userReq.getUsername(),
                userReq.getPassword(),
                userReq.getUsermobile(),
                userReq.getRole(),
                userReq.getName());
        return userRepository.save(user);
    }

      public List<Userr> getall() {
        return userRepository.findAll();
    }

    public Userr editActivity(Userr user) throws ActivityNotFoundException {
        int id = user.getUserid();
        Boolean userID = userRepository.existsById(id);
        if (userID) {
            Userr userr = userRepository.save(user);
            return userr;
        } else {
            throw new ActivityNotFoundException("activity not found with id : " + id);
        }
    }

    public String deleteUserById(Integer id) throws ActivityNotFoundException {
        Boolean isActivityExixt = userRepository.existsById(id);
        if (isActivityExixt) {
            userRepository.deleteById(id);
            return "Activity deleted Successfully";
        } else {
            throw new ActivityNotFoundException("No activity found with id :" + id);
        }
    }

    public String encodePassword(String a) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(a);
        return encodedPassword;
    }

    public List<String> getAllUsernames() {
        return userRepository.getUsernames();
    }
}
