package com.hunter333.recipes.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hunter333.recipes.enumerations.TimeMeasure;

import lombok.Data;

/**
 * 
 * @author Hunter333
 * @date 6.10.2018 г.
 */
@Entity
@Data
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double timeAmount;
	@Enumerated(value = EnumType.STRING)
	private TimeMeasure timeMeasure;

	public Time setTimeAmountBuilder(Double time) {
		this.timeAmount = time;
		return this;
	}

	public Time setTimeMeasureBuilder(TimeMeasure timeMeasure) {
		this.timeMeasure = timeMeasure;
		return this;
	}
}
