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
import uz.pdp.homework1.payload.FilialeDto;
import uz.pdp.homework1.service.FilialeService;

@RestController
@RequestMapping("/api/filiale")
public class FilialeController {

    @Autowired
    FilialeService filialeService;

    @PreAuthorize(value = "hasAuthority('ADD_FILIALE')")
    @PostMapping
    public HttpEntity<?> add(@RequestBody FilialeDto filialeDto){
        ApiResponse add = filialeService.add(filialeDto);
        return ResponseEntity.status(add.isSucces()?200:409).body(add);
    }
}
