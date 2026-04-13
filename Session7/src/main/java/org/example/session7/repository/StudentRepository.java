package org.example.session7.repository;

import org.example.session7.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class StudentRepository {
    List<Student> studentsRepositry = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"Phạm Thành Đạt",false,20,"Ninh Bình"),
                    new Student(2,"Trần Việt Anh",false,20,"Hưng Yên"),
                    new Student(3,"Nguyễn Thị Phương",true,20,"Thái Bình")
            )
    );

    public List<Student> getStudents() {
        return studentsRepositry;
    }
    public void addStudent(Student student) {
        studentsRepositry.add(student);

    }
}
