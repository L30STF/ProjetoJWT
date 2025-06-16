package ProjetoJWT.Controller;


import ProjetoJWT.Model.User;
import ProjetoJWT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/getCurrent")
    public ResponseEntity<UserDetails> getUser(@AuthenticationPrincipal UserDetails user) {
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        try{
            return ResponseEntity.ok(userService.getUserById(id));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        try{
            return ResponseEntity.ok(userService.deleteUser(id));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/edit")
    public ResponseEntity<User> updateSelf(@AuthenticationPrincipal UserDetails user, @RequestBody User updatedUser) {
        try{
            return ResponseEntity.ok(userService.updateUser(user.getUsername(),updatedUser));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        try{
            return ResponseEntity.ok(userService.updateUserById(id,updatedUser));
        }
        catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}