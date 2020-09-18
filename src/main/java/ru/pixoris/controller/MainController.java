package ru.pixoris.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.pixoris.model.Student;
import ru.pixoris.model.StudentRepo;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/main")
public class MainController {
    private final StudentRepo studentRepo;

    @Autowired
    public MainController(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Student> get() {
        return studentRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<Student> findById(@PathVariable("id") Long id){
        return studentRepo.findById(id);
    }

    @PostMapping()
    public Student add(@RequestBody Student student) {
        return studentRepo.save(student);
    }
}