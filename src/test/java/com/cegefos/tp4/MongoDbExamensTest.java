package com.cegefos.tp4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import com.cegefos.tp4.entity.Examen;
import com.cegefos.tp4.repository.ExamenRepository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@RunWith(SpringRunner.class)
@SpringBootTest
class MongoDbExamensTest {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4;

    private Examen examen1;
    private Examen examen2;
    private Examen examen3;
    private Examen examen4;

    @Autowired
    private ExamenRepository examenRepository;

    @BeforeEach
    void setUp() throws ParseException {
        date1 = simpleDateFormat.parse("2022-01-31 09:00:00");
        date2 = simpleDateFormat.parse("2022-02-15 09:00:00");
        date3 = simpleDateFormat.parse("2022-02-18 09:00:00");
        date4 = simpleDateFormat.parse("2022-02-25 09:00:00");

        examen1 = new Examen(date1);
        examen2 = new Examen(date2);
        examen3 = new Examen(date3);
        examen4 = new Examen(date4);
    }


    @Test
    void createExamens() {
        examenRepository.save(examen1);
        examenRepository.save(examen2);
        examenRepository.save(examen3);
        examenRepository.save(examen4);
    }

    @Test
    void findExamenAtGigenDate() {
        examenRepository.findExamenByDateExam(date1).forEach(System.out::println);
        examenRepository.findExamenByDateExam(date4).forEach(System.out::println);
    }

    @Test
    void findAllExams() {
        examenRepository.findAll().forEach(System.out::println);
    }

    @Test
    void countingTheNumberOfExamens() {
        System.out.println(examenRepository.count());
    }

    @Test
    void findOne_ExamenByQueryByExample() {
        var examen = new Examen();
        examen.setDateExam(date1);

        var matcher = ExampleMatcher.matching().withMatcher("dateExam", exact());
        var examMatcher = Example.of(examen, matcher);
        Optional<Examen> examenOptional = examenRepository.findOne(examMatcher);
        examenOptional.ifPresent(System.out::println);
    }

    @Test
    void findExamenById() {
        Optional<Examen> examenOptional = examenRepository.findById("6341d8e9d657d07fbe083e00");
        examenOptional.ifPresent(System.out::println);

    }

    @Test
    void updateAnExamen() {
        Optional<Examen> oldExam = examenRepository.findById("6341d8e9d657d07fbe083e00");

        var newDate = new Date(System.currentTimeMillis());

        if (oldExam.isPresent()) {
            Examen updatedExam = oldExam.get();
            updatedExam.setDateExam(newDate);
            examenRepository.save(updatedExam);
        }

        System.out.println(oldExam);

    }


    @Test
    void deleteAnExamen() {
        examenRepository.deleteById("6341d8e9d657d07fbe083e00");
    }


    @Test
    void deleteAllExamens() {
        examenRepository.deleteAll();
        examenRepository.findAll().forEach(System.out::println);
    }


}
