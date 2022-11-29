package com.springformmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import model.Student;
import model.StudentDAO;

@Controller
public class StudentController {

    @RequestMapping(value = "/student" , method = RequestMethod.GET)
	public ModelAndView student(@ModelAttribute("student") Student student)
	{ 
	     return new ModelAndView("student", "command", student); 
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("student") Student student, ModelMap model) {
		StudentDAO.addStudent(student);
		model.addAttribute("name", student.getSname());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getSid());

		return "result";
	}
}
