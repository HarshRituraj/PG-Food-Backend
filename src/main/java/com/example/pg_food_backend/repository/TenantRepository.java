package com.example.pg_food_backend.repository;

import com.example.pg_food_backend.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    @Modifying
    @Transactional
            @Query(value = "Delete from Tenant t where t.name = :name And t.room_no = :roomNo AND day(curdate()) = day(t.date) AND month(curdate()) = month(t.date) AND year(curdate()) = year(t.date)", nativeQuery = true)
    int deleteResponse(String name, long roomNo);
}
