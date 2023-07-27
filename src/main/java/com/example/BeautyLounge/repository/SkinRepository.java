package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinRepository extends JpaRepository<Skin, Integer> {

}
