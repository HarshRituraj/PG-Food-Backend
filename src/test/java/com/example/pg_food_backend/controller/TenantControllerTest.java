package com.example.pg_food_backend.controller;

import com.example.pg_food_backend.dto.ResponseDto;
import com.example.pg_food_backend.entity.Tenant;
import com.example.pg_food_backend.service.TenantService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TenantController.class)
public class TenantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TenantService tenantService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddResponse() throws Exception {
        Tenant tenant = new Tenant(1L, 101, "Confirmed", new Date(), "Harsh");

        when(tenantService.addResponse(any(Tenant.class))).thenReturn(tenant);

        mockMvc.perform(post("/tenant-controller/add-response")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tenant)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tenantId").value(1L))
                .andExpect(jsonPath("$.roomNo").value(101))
                .andExpect(jsonPath("$.response").value("Confirmed"))
                .andExpect(jsonPath("$.name").value("Harsh"));
    }

    @Test
    public void testGetAllResponses() throws Exception {
        ResponseDto responseDto = new ResponseDto(); // populate with dummy data if needed

        when(tenantService.getAllResponses()).thenReturn(responseDto);

        mockMvc.perform(get("/tenant-controller/get-all-responses"))
                .andExpect(status().isOk());
        // Add jsonPath assertions if ResponseDto has fields to verify
    }

    @Test
    public void testDeleteTodayResponse() throws Exception {
        when(tenantService.deleteResponse("Harsh", 432L)).thenReturn("Deleted");

        mockMvc.perform(delete("/tenant-controller/delete-today-response")
                        .param("name", "Harsh")
                        .param("room no", "432"))
                .andExpect(status().isOk())
                .andExpect(content().string("Deleted"));
    }
}