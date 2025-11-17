package com.anganwadi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "distribution")
public class Distribution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "month")
	private String month;
	@Column(name = "year")
	private Integer year; // e.g. 2025
	@ManyToOne
	@JoinColumn(name = "woman_id", nullable = false)
	private PregnantWomen woman;

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	public Distribution() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public PregnantWomen getWoman() {
		return woman;
	}

	public void setWoman(PregnantWomen woman) {
		this.woman = woman;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}