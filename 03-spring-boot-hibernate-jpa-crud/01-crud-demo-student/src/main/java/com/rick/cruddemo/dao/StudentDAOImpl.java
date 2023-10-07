package com.rick.cruddemo.dao;

import com.rick.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

  // Define entityManager
  private EntityManager entityManager;

  // inject entity manager using construction
  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  // implement save method
  @Override
  @Transactional
  public void save(Student student) {
    entityManager.persist(student);
  }

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    TypedQuery<Student> theQuery = entityManager.createQuery(
      "FROM Student order by lastName",
      Student.class
    );
    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastName(String theLastName) {
    TypedQuery<Student> theQuery = entityManager.createQuery(
      "From Student where lastName=:theData",
      Student.class
    );

    theQuery.setParameter("theData", theLastName);

    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void update(Student student) {
    entityManager.merge(student);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    Student temStudent = findById(id);
    entityManager.remove(temStudent);
  }

  @Override
  @Transactional
  public Integer deleteAll() {
    Integer rows = entityManager
      .createQuery("DELETE FROM Student")
      .executeUpdate();
    return rows;
  }
}
