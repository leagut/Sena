package com.Sena_Market.web.controller;

import com.Sena_Market.domain.Service.UserService;
import com.Sena_Market.persistence.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{/id}")
    public ResponseEntity<Usuario>getById( @PathVariable("id") int usuario){
        return userService.getById(usuario)
                .map(usuario1 -> new ResponseEntity<>(usuario1,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/save")
    public ResponseEntity<Usuario>save( @RequestBody Usuario usuario){
        return new ResponseEntity<>(userService.save(usuario),HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUsuario(@PathVariable("id") int userId ){
            if(userService.delete(userId)){
                return  new ResponseEntity(HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }





}
