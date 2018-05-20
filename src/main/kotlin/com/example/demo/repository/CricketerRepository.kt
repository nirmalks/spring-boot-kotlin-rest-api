import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.data.repository.CrudRepository

@Repository	
interface CricketerRepository : JpaRepository<Cricketer,Long>{
}