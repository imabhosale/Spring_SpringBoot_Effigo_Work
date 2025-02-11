package com.ems.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ems.config.TokenProvider;
import com.ems.model.AuthToken;
import com.ems.model.LoginUser;
import com.ems.model.User;
import com.ems.model.UserDto;
import com.ems.repository.UserDao;
import com.ems.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;

   
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {
        System.out.println("Attempting authentication for: " + loginUser.getEmail());

        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginUser.getEmail(),
                    loginUser.getPassword()
                )
            );
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenUtil.generateToken(authentication);
            return ResponseEntity.ok(new AuthToken(token));

        } catch (BadCredentialsException e) {
            System.out.println("Authentication failed: Bad credentials for user " + loginUser.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    
    
    @Autowired
    private UserDao userDao;

    /**
     * Saves a new user.
     *
     * @param user The user to be saved.
     * @return The saved user.
     */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }

    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Admins Can Read This";
    }

    /**
     * Returns a message that can be accessed by any user.
     *
     * @return A message that can be accessed by any user.
     */
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value="/userping", method = RequestMethod.GET)
    public String userPing(){
        return "Any User Can Read This";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/create/user", method = RequestMethod.POST)
    public User createEmployee(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/find/all", method = RequestMethod.GET)
    public List<User> getAllList(){
        return userService.findAll();
    }
    
   
}