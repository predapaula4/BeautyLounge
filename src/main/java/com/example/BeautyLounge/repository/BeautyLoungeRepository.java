package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.BeautyLounge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeautyLoungeRepository extends JpaRepository<BeautyLounge, Integer> {

}
