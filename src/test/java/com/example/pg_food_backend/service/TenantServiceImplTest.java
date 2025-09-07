package com.example.pg_food_backend.service;

import com.example.pg_food_backend.entity.Tenant;
import com.example.pg_food_backend.repository.TenantRepository;
import org.junit.jupiter.api.Assertions;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
@ExtendWith(MockitoExtension.class)
public class TenantServiceImplTest {

    @Mock
    TenantRepository tenantRepository;

    @InjectMocks
    TenantServiceImpl tenantServiceImpl;

    @Test
    public void testAddResponse(){
        Tenant tenant = new Tenant(1L,432,"yes", new Date(), "Harsh");
        when(tenantRepository.save(tenant)).thenReturn(tenant);
        Tenant t = tenantServiceImpl.addResponse(tenant);
        assertThat(t).isNotNull();

    }

    @Test
    public void testGetAllResponses(){
        Tenant tenant = new Tenant(1L,432,"yes", new Date(), "Harsh");
        List<Tenant> allResponse = new ArrayList<>();
        allResponse.add(tenant);
        when(tenantRepository.findAll()).thenReturn(allResponse);

        assertThat(tenantServiceImpl.getAllResponses()).isNotNull();
    }

    @Test
    public void testDeleteResponseSuccess() throws Exception {

        when(tenantRepository.deleteResponse("Harsh",432)).thenReturn(1);

        assertThat(tenantServiceImpl.deleteResponse("Harsh",432)).isEqualTo("Tenant deleted successfully.");
    }

    @Test
    public void testDeleteResponseException() throws Exception{
        when(tenantRepository.deleteResponse("Harsh",432)).thenReturn(0);
        assertThrows(Exception.class, ()->{tenantServiceImpl.deleteResponse("Harsh",432);});
    }
}
