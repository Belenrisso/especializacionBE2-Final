package com.example.msusers.controller;

import com.example.msusers.domain.Bill;
import com.example.msusers.repository.FeignBillRepository;
import com.example.msusers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    FeignBillRepository feignBillRepository;


    @GetMapping("/findBy/{id}")
    public ResponseEntity<ResponseEntity<List<Bill>>> findAll(@PathVariable String id) {
        return ResponseEntity.ok().body(feignBillRepository.findById(id));


    }
}