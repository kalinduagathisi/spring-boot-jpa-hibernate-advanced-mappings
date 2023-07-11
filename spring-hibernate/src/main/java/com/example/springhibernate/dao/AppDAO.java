package com.example.springhibernate.dao;

import com.example.springhibernate.entity.Instructor;
import com.example.springhibernate.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findByID(int id);

    void deleteById(int id);

    InstructorDetail findByInstructorDetailID(int id);

    void deleteByInstructorDetails(int id);
}
