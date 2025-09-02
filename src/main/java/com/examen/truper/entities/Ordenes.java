package com.examen.truper.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Ordenes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ordenId;
	@JoinColumn(name = "sucursalId")
	private Long sucursalId;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "total")
	private double total;

}
