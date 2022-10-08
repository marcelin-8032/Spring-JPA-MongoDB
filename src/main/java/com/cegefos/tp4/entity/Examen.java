package com.cegefos.tp4.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "examen")
public class Examen {
	
	@Id
	private String examenId;

	private Date dateExam;

	public Examen(Date dateExam) {
		super();
		this.dateExam = dateExam;
	}
	
	@Override
	public String toString() {
		return "Examen [dateExam=" + dateExam + "]";
	}


}
