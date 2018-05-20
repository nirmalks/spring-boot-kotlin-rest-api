package com.example.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody

import Cricketer
import CricketerRepository
import CricketerService
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api")
class CricketerController(private val cricketerService: CricketerService , private val cricketerRepository: CricketerRepository){
	
	@GetMapping("/api/cricketers/{id}")
	fun getCricketer(@PathVariable("id") id: Long):ResponseEntity<Cricketer>  {
		val cricketer = cricketerService.findById(id)
		return ResponseEntity<Cricketer>(cricketer as Cricketer, HttpStatus.OK);
	}
	
	@GetMapping("/api/cricketers/")
	fun getAllCricketers() :ResponseEntity<List<Cricketer>>  {
		println("inside get all criceketers")
		var cricketersList: ArrayList<Cricketer> =  cricketerService.getAllPlayers() as (ArrayList<Cricketer>)
		return ResponseEntity<List<Cricketer>>(cricketersList, HttpStatus.OK)
	}
	
	@PostMapping("/cricketer/")
	fun addCricketer(@RequestBody cricketer:Cricketer):ResponseEntity<Cricketer>  {
		val cCricketer : Cricketer = Cricketer(name = cricketer.name
				, country = cricketer.country
				, highestScore = cricketer.highestScore)
		cricketerRepository.save(cCricketer)
		return ResponseEntity<Cricketer>(cricketer , HttpStatus.OK)
	}
	
	@PutMapping("/cricketer/{id}")
	fun updateCricketer(@PathVariable("id") id: Long, @RequestBody cricketer: Cricketer ):ResponseEntity<Cricketer> {
		var cCricketer = cricketerService.findById(id)
		cCricketer  = Cricketer(name = cricketer.name
				, country = cricketer.country
				, highestScore = cricketer.highestScore)
		cricketerRepository.save(cCricketer)
		return ResponseEntity<Cricketer>(cricketer, HttpStatus.OK)
	}
	
	@DeleteMapping("/cricketer/{id}")
	fun deleteCricketer(@PathVariable("id") id:Long ):ResponseEntity<String> {
		val cCricketer :Cricketer  = cricketerService.findById(id) as Cricketer
		cricketerRepository.delete(cCricketer)
		return ResponseEntity<String>("cricketer removed", HttpStatus.OK)
	}
}