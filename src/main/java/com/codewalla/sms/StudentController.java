package com.codewalla.sms;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController  //by writing this telling java application--> this class will contains API endpoints

public class StudentController {

    //Database
    HashMap<Integer, Student> studentDb=new HashMap<>();


    //ADD a Student
    @PostMapping("/add_student")
    public String addStudent(@RequestBody() Student student){

        //Add it to our DB

        int key=student.getId();

        //add it tu student db
        studentDb.put(key,student);

        return "Student added successfully.";
    }


    //GET a Student
    @GetMapping("/get_student_by_id")
    public Student getStudentById(@RequestParam("id") Integer id){

        return studentDb.get(id);
    }

    //GET a student by name
    @GetMapping("/get_student_by_name")
    public Student getStudentByName(@RequestParam("name") String searchName){

        //iterating over hashmap= DB
        for(Student s: studentDb.values()){
            if(s.getName().equals(searchName)){
                return s;
            }
        }
        //if not found in DB
        return null;
    }

    //Get student by path variable
    @GetMapping("/get_by_path_variable/{id}")
    public Student getByPathVariable(@PathVariable("id") Integer id){

        Student student=studentDb.get(id);
        return student;
    }


    //UPDATE a Student
    @PutMapping("/update_student")
    public String updateStudent(@RequestBody() Student student){

        int key=student.getId();

        studentDb.put(key,student);

        return "Updated successfully.";
    }


    //DELETE a Student
    @DeleteMapping("/delete_student")
    public String deleteStudent(@RequestParam("id") Integer id){

        for(int i: studentDb.keySet()){
            if(i==id){
                studentDb.remove(i);
                return "Student deleted successfully.";
            }
        }
        return "Student not found.";
    }
}
