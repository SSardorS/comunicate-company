package uz.pdp.homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.SimCardDto;
import uz.pdp.homework1.service.SimCardService;

@RestController
@RequestMapping("/api/simcard")
public class SimCardController {
    @Autowired
    SimCardService simCardService;

    @PreAuthorize(value = "hasAuthority('ADD_SIMCARD')")
    @PostMapping
    public HttpEntity<?> add(@RequestBody SimCardDto simCardDto){
        ApiResponse add = simCardService.add(simCardDto);
        return ResponseEntity.status(add.isSucces()?200:409).body(add);
    }
}
