package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository
import com.example.demo.model.Cricketer

@Repository	
interface CricketerRepository : JpaRepository<Cricketer,Long>{
}