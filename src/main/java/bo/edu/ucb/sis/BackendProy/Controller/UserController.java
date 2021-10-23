package bo.edu.ucb.sis.BackendProy.Controller;

import bo.edu.ucb.sis.BackendProy.entity.User;
import bo.edu.ucb.sis.BackendProy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping(value = "/user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        if(userService.findUser(user)==null){
            userService.save(user);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }
}
