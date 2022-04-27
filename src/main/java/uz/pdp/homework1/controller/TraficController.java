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
import uz.pdp.homework1.payload.TraficDto;
import uz.pdp.homework1.repository.SimCardRepository;
import uz.pdp.homework1.repository.TraficRepository;
import uz.pdp.homework1.service.TraficsSevice;

@RestController
@RequestMapping("/api/trafic")
public class TraficController {

    @Autowired
    TraficsSevice traficsSevice;


    @PreAuthorize(value = "hasAuthority('ADD_TRAFIC')")
    @PostMapping
    public HttpEntity<?> add(@RequestBody TraficDto traficDto){
        ApiResponse add = traficsSevice.add(traficDto);
        return ResponseEntity.status(add.isSucces() ?200:409).body(add);
    }


}
