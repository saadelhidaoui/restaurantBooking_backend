package com.example.restaurant.ws;

import com.example.restaurant.bean.Reservation;
import com.example.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/reservation")
public class ReservationWs {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/ref/{ref}")
    public Reservation findByRef(@PathVariable String ref) {
        return reservationService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return reservationService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/date/{date}")
    public List<Reservation> findByDate(String date) {
        return reservationService.findByDate(date);
    }

    @PostMapping("/")
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
}
