package com.example.pg_food_backend.repository;

import com.example.pg_food_backend.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
