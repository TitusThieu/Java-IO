package com.fa.dao;

import java.util.ArrayList;
import java.util.List;

import com.fa.entity.Student;
import com.fa.io.FileIO;

/**
 * This class to calls to retrieve objects
 */
public class StudentDao {

    public StudentDao() {

    }

    public List<Student> getAllStudentFromFile() {
        List<Student> students = new ArrayList<>();
        if (FileIO.checkData(FileIO.FILE_STUDENT)) {
            students = (List<Student>) FileIO.readFile(FileIO.FILE_STUDENT);
        }
        return students;
    }

    public void save(Student student) {
        List<Student> students = getAllStudentFromFile();
        students.add(student);
        FileIO.writeFile(students, FileIO.FILE_STUDENT);
    }
}
