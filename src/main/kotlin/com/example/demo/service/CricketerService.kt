package com.example.demo.service
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.example.demo.repository.CricketerRepository
import com.example.demo.model.Cricketer

@Service
class CricketerService(@Autowired var cricketerRepository:CricketerRepository) {
	fun save(cricketer: Cricketer ): Unit {
		cricketerRepository.save(cricketer)
	}

	fun findById(id:Long):Any {
		return cricketerRepository.findById(id)
	}
		
	fun getAllPlayers():List<Cricketer> {
		return cricketerRepository.findAll()
	}
}
