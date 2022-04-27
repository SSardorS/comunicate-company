package uz.pdp.homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.homework1.entity.USSDcode;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.service.USSDCodeService;

import java.util.List;

@RestController
@RequestMapping("/api/ussd")
public class USSDCodeController {
    @Autowired
    USSDCodeService ussdCodeService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody USSDcode ussDcode){
        ApiResponse add = ussdCodeService.add(ussDcode);
        return ResponseEntity.status(add.isSucces()?200:409).body(add);
    }

    @GetMapping
    public HttpEntity<?> getAll(){
        List<USSDcode> all = ussdCodeService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{code}")
    public HttpEntity<?> getAll(@PathVariable int code){
        ApiResponse byCode = ussdCodeService.getByCode(code);
        return ResponseEntity.status(byCode.isSucces()?200:409).body(byCode);
    }


}
