package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.Eyebrows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EyebrowsRepository extends JpaRepository<Eyebrows, Integer> {

}