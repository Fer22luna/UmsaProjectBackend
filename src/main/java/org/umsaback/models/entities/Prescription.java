package org.umsaback.models.entities;

import java.time.LocalDate;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.smallrye.common.constraint.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Prescription")
public class Prescription {
	
	@Id
	@UuidGenerator
	private String idString;
	
	@Column
	private String description;
	
	@Column @NotNull
	private LocalDate prescDate;
	
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "paciente_id", nullable = false)
//	@JsonBackReference
	private Doctor doctor;
	
//	@ManyToOne(optional = false)
//	@JoinColumn(name = "paciente_id", nullable = false)
//	@JsonBackReference
	private Paciente patient;
}
