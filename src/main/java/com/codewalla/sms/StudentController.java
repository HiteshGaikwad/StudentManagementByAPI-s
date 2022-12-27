package com.codewalla.sms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController  //by writing this telling java application--> this class will contains API endpoints

public class StudentController {

    //Database
    HashMap<Integer, Student> studentDb=new HashMap<>();


    //ADD a Student
    @PostMapping("/add_student")

    public ResponseEntity<String> addStudent(@RequestBody() Student student){

        //Add it to our DB

        int key=student.getId();

        //add it tu student db
        studentDb.put(key,student);

        return new ResponseEntity<>("Student added successfully.", HttpStatus.ACCEPTED);
    }


    //GET a Student
    @GetMapping("/get_student_by_id")
    public ResponseEntity<Student> getStudentById(@RequestParam("id") Integer id){

        if(studentDb.containsKey(id)) {
            return new ResponseEntity<>(studentDb.get(id), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //GET a student by name
    @GetMapping("/get_student_by_name")
    public ResponseEntity<Student> getStudentByName(@RequestParam("name") String searchName){

        //iterating over hashmap= DB
        for(Student s: studentDb.values()){
            if(s.getName().equals(searchName)){
                return new ResponseEntity<>(s,HttpStatus.FOUND);
            }
        }
        //if not found in DB
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //Get student by path variable
    @GetMapping("/get_by_path_variable/{id}")
    public ResponseEntity<Student> getByPathVariable(@PathVariable("id") Integer id){

        if(studentDb.containsKey(id)) {
            return new ResponseEntity<>(studentDb.get(id), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    //UPDATE a Student
    @PutMapping("/update_student")
    public ResponseEntity<String> updateStudent(@RequestBody() Student student){

        int key=student.getId();

        studentDb.put(key,student);

        return new ResponseEntity<>("Updated successfully.",HttpStatus.OK);
    }


    //DELETE a Student
    @DeleteMapping("/delete_student")
    public ResponseEntity<String> deleteStudent(@RequestParam("id") Integer id){

        for(int i: studentDb.keySet()){
            if(i==id){
                studentDb.remove(i);
                return new ResponseEntity<>("Student deleted successfully.",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Student not found.",HttpStatus.NOT_FOUND);
    }
}
