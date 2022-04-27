package uz.pdp.homework1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.homework1.payload.ApiResponse;
import uz.pdp.homework1.payload.Period;
import uz.pdp.homework1.service.SimCardService;

@RestController
@RequestMapping("/api/dashboard")
@EnableGlobalMethodSecurity
public class DashboardController {

    @Autowired
    SimCardService simCardService;

    @PreAuthorize("hasAnyAuthority('ADD_USER, EDIT_USER, DELETE_USER, VIEW_USER, ADD_ROLE, EDIT_ROLE,  DELETE_ROLE,  VIEW_ROLE, ADD_FILIALE, EDIT_FILIALE, DELETE_FILIALE, VIEW_FILIALE,  ADD_SIMCARD,EDIT_SIMCARD,  DELETE_SIMCARD, VIEW_SIMCARD, ADD_TRAFIC,  DELETE_TRAFIC, VIEW_TRAFIC,')")
    @GetMapping
    public HttpEntity<?> getSaleReport(@RequestBody Period period){
        ApiResponse salesReport = simCardService.getSalesReport(period);
        return ResponseEntity.status(salesReport.isSucces()?200:409).body(salesReport);
    }
}
