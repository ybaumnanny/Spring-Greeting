package com.bridgelabz.repository;

import com.bridgelabz.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GreetingRepository extends JpaRepository<Greeting,Long> {
}