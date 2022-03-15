package com.example.cleancode.service;

import com.example.cleancode.exception.ErrorCode;
import com.example.cleancode.exception.HouseUtilsException;
import com.example.cleancode.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository
                .findById(apartmentId)
                .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
                .getPrice();
    }

}
