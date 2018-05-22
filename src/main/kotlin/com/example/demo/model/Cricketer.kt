package com.example.demo.model
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Entity

@Entity
data class Cricketer(@Id @GeneratedValue var id:Number? = null, var name: String, var country: String, var highestScore: Number ) {
	
}