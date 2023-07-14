package com.example.BeautyLounge.repository;

import com.example.BeautyLounge.model.Ochi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OchiRepository extends JpaRepository<Ochi, Integer> {

}
