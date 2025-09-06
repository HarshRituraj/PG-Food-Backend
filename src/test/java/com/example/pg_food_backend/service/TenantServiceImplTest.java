package com.example.pg_food_backend.service;

import com.example.pg_food_backend.entity.Tenant;
import com.example.pg_food_backend.repository.TenantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TenantServiceImplTest {

    @Mock
    TenantRepository tenantRepository;

    @InjectMocks
    TenantServiceImpl tenantServiceImpl;

    @Test
    public void testAddResponse(){
        Tenant tenant = new Tenant(1L,432,"yes", new Date());
        when(tenantRepository.save(tenant)).thenReturn(tenant);
        Tenant t = tenantServiceImpl.addResponse(tenant);
        assertThat(t).isNotNull();

    }

    @Test
    public void testGetAllResponses(){
        Tenant tenant = new Tenant(1L,432,"yes", new Date());
        List<Tenant> allResponse = new ArrayList<>();
        allResponse.add(tenant);
        when(tenantRepository.findAll()).thenReturn(allResponse);

        assertThat(tenantServiceImpl.getAllResponses()).isNotNull();
    }
}
