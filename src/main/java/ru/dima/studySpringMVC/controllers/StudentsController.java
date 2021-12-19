package ru.dima.studySpringMVC.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.dima.studySpringMVC.dao.StudentsDAO;
import ru.dima.studySpringMVC.models.Student;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentsController {
    StudentsDAO studentsDAO;
    @Autowired
    public StudentsController(StudentsDAO studentsDAO) {
        this.studentsDAO = studentsDAO;
    }

    @GetMapping()
    public String showAll(){
        return "students/listStudents";
    }

    @GetMapping("/{id}")
    public String showStudent(@PathVariable("id") int id,
            Model model){
        model.addAttribute("student",studentsDAO.getStudent(id));
        return "students/student";
    }

    @GetMapping("/new")
    public String createStudent(Model model){
        model.addAttribute("student",new Student());
        return "students/createStudent";
    }

    @PostMapping()
    public String createStudent(@ModelAttribute @Valid Student student,
                                BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "students/createStudent";
        }
        studentsDAO.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String editStudent(@PathVariable("id") int id,
            Model model){
        model.addAttribute("student",studentsDAO.getStudent(id));
        return "students/editStudent";
    }

    @PatchMapping("/{id}") //PATCH
    public String editStudent(@ModelAttribute @Valid Student student,
                              BindingResult bindingResult,
                              @PathVariable("id") int id){
        if (bindingResult.hasErrors()){
            return "students/editStudent";
        }
    studentsDAO.editStudent(student);
    return "redirect:/students";
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentsDAO.deleteStudent(id);
        return "redirect:/students";
    }

    @ModelAttribute("students")
    public List<Student> AddAttribute(){
        return studentsDAO.getStudentList();
    }
}
