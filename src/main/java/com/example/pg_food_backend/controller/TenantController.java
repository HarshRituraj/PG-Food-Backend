package com.example.pg_food_backend.controller;

import com.example.pg_food_backend.dto.ResponseDto;
import com.example.pg_food_backend.entity.Tenant;
import com.example.pg_food_backend.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tenant-controller")
public class TenantController {
    @Autowired
    TenantService tenantService;

    @PostMapping("/add-response")
    public ResponseEntity<Tenant> addResponse(@RequestBody Tenant tenant) {
        return ResponseEntity.ok(tenantService.addResponse(tenant));
    }

    @GetMapping("/get-all-responses")
    public ResponseEntity<ResponseDto> getAllResponses() {
        return ResponseEntity.ok(tenantService.getAllResponses());
    }

    @DeleteMapping("/delete-today-response")
    public ResponseEntity<String> deleteTodayResponse(@RequestParam("name") String name, @RequestParam("room no") long roomNo) throws Exception{
        return ResponseEntity.ok(tenantService.deleteResponse(name, roomNo));
    }
}
