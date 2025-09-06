package com.example.pg_food_backend.service;

import com.example.pg_food_backend.dto.ResponseDto;
import com.example.pg_food_backend.entity.Tenant;

public interface TenantService {

    Tenant addResponse(Tenant tenant);
    ResponseDto getAllResponses();
}
