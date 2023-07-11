package com.example.springhibernate.dao;

import com.example.springhibernate.entity.Instructor;
import com.example.springhibernate.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImplementation implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findByID(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructorToBeDeleted = entityManager.find(Instructor.class, id);
        entityManager.remove(instructorToBeDeleted);
    }

    @Override
    public InstructorDetail findByInstructorDetailID(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteByInstructorDetails(int id) {
        InstructorDetail instructorDetailToBeDelete = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetailToBeDelete);
    }
}
