package tarun.microservice.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tarun.microservice.employee.model.Employee;

public interface CRUDRepository extends JpaRepository<Employee, Integer> {

}
