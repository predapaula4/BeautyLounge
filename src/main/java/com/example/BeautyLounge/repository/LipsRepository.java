package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.Lips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LipsRepository extends JpaRepository<Lips,Integer> {
}
