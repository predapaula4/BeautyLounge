package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.Eye;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EyeRepository extends JpaRepository<Eye, Integer> {

}
