package com.cegefos.tp4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cegefos.tp4.entity.Examen;

import java.util.Collection;
import java.util.Date;

@Repository
public interface ExamenRepository extends MongoRepository<Examen, String> {

    Collection<Examen> findExamenByDateExam(Date dateExam);

}
