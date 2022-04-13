package com.example.restaurant.service;

import com.example.restaurant.bean.Reservation;
import com.example.restaurant.dao.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    public Reservation findByRef(String ref) {
        return reservationDao.findByRef(ref);
    }


    public int deleteByRef(String ref) {
        return reservationDao.deleteByRef(ref);
    }

    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    public List<Reservation> findByDate(String date) {
        return reservationDao.findByDate(date);
    }

    public int save(Reservation reservation) {
        if(findByRef(reservation.getRef()) != null){
            return -1;
        }else if(reservation.getNbrPersonnes() > 4){
            return -2;
        }else{
            reservationDao.save(reservation);
            return 1;
        }
    }
}
