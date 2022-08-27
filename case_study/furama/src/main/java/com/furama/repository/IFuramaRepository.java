package com.furama.repository;

import com.furama.model.Furama;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFuramaRepository extends JpaRepository<Furama,Integer> {
}
