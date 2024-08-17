package com.ltp.gradesubmission.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ltp.gradesubmission.Grade;
import com.ltp.gradesubmission.service.GradeService;

@Controller
public class GradeController {

    // GradeRepository gradeRepository = new GradeRepository();
    GradeService gradeService = new GradeService();
    
    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        
        model.addAttribute("grade", gradeService.getGradeById(id));

        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {

        System.out.println("Has error: " + result.hasErrors());

        if(result.hasErrors()){
            return "form";
        }

        // System.out.println(grade.getSubject());
        // System.out.println(grade.getName());

        gradeService.submitGrade(grade);

        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", gradeService.getGrades());
        return "grades";
    }

}