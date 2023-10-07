package com.rick.cruddemo.dao;

import com.rick.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {
  void save(Student student);
  Student findById(Integer id);
  List<Student> findAll();
  List<Student> findByLastName(String data);
  void update(Student student);
  void delete(Integer id);
  Integer deleteAll();
}
