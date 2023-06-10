package tarun.microservice.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tarun.microservice.employee.dao.CRUDRepository;
import tarun.microservice.employee.model.Employee;

@RestController
@RequestMapping("/employee")
public class CRUDController {

    @Autowired
    CRUDRepository repository;

    @GetMapping("/get/{id}")
    public ResponseEntity getEmployee(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(repository.findById(id).
                orElse(new Employee(-1, "Not Found", "No Dept", -1L)), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity getAllEmployee() {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(repository.save(employee), HttpStatus.CREATED);
    }
}
