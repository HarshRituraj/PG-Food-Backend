package com.example.pg_food_backend.service;

import com.example.pg_food_backend.dto.ResponseDto;
import com.example.pg_food_backend.entity.Tenant;
import com.example.pg_food_backend.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantRepository tenantRepository;

    public Tenant addResponse(Tenant tenant) {
        tenant.setDate(new Date());
        return tenantRepository.save(tenant);
    }

    public ResponseDto getAllResponses() {
        List<Tenant> tenants = tenantRepository.findAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Tenant> todayResponses = tenants.stream().filter(tenant -> tenant.getDate().toString().split(" ")[0].equals(sdf.format(new Date()).toString().split(" ")[0])).toList();
        System.out.println(tenants.get(0).getDate().toString().split(" ")[0]);
        System.out.println(todayResponses);

        int yesCount = (int) todayResponses.stream().filter(tenant -> tenant.getResponse().equals("yes")).count();
        int noCount = (int) todayResponses.stream().filter(tenant -> tenant.getResponse().equals("no")).count();
        int notSureCount = (int) todayResponses.stream().filter(tenant -> tenant.getResponse().equals("not sure")).count();

        return new ResponseDto(yesCount, noCount, notSureCount, new Date());
    }

    public String deleteResponse(String name, long roomNo) throws Exception {
        int rowCount = tenantRepository.deleteResponse(name, roomNo);
        if (rowCount > 0)
            return "Tenant deleted successfully.";
        else
            throw new Exception("Deletion not successfull.");
    }
}
