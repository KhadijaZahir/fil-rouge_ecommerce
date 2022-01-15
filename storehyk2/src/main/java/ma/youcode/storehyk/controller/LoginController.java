package ma.youcode.storehyk.controller;

import ma.youcode.storehyk.dto.UserDTO;
import ma.youcode.storehyk.global.GlobalData;
import ma.youcode.storehyk.model.Role;
import ma.youcode.storehyk.model.User;
import ma.youcode.storehyk.repository.RoleRepository;
import ma.youcode.storehyk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }//page login

    @GetMapping("/register")
    public String registerGet(Model model){
        return "register";
    } //page register

    @PostMapping("/register")
    public String registerPost(@ModelAttribute User userModel, HttpServletRequest request) throws ServletException{
        //Password story from signed form to encrypted form
        String password = userModel.getPassword();
        userModel.setPassword(bCryptPasswordEncoder.encode(password));
        //set default role user,admin
        List<Role> roles = new ArrayList<>();
      //HERE  //roles.add(roleRepository.findById(1).get());
        roles.add(roleRepository.findById(2).get());
        userModel.setRoles(roles);
        userRepository.save(userModel);
        //login & go to home page
        request.login(userModel.getEmail(), password);
        return "redirect:/";
    }//after register success
}
