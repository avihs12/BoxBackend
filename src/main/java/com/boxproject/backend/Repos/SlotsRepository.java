package com.boxproject.backend.Repos;

import com.boxproject.backend.Entities.Slots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotsRepository extends JpaRepository<Slots, Integer> {
}
