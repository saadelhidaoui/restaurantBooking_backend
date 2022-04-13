package com.example.restaurant.dao;

import com.example.restaurant.bean.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Long> {
    Reservation findByRef(String ref);
    int deleteByRef(String ref);
    List<Reservation> findAll();
    List<Reservation> findByDate(String date);
}
