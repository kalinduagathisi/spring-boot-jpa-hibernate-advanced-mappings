package com.example.springhibernate.dao;

import com.example.springhibernate.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findByID(int id);

    void deleteById(int id);
}
