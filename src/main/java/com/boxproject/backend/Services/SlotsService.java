package com.boxproject.backend.Services;

import com.boxproject.backend.Entities.Slots;
import com.boxproject.backend.Repos.SlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotsService {
    @Autowired
    private SlotsRepository slotsRepository;

    public List<Slots> findallslots() {
        return slotsRepository.findAll();
    }

}
