package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.Ten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenRepository extends JpaRepository<Ten, Integer> {

}
