package com.academysmart.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	private long id;

	private int ticket_Price;

	@ManyToOne
	@JoinColumn(name = "FLIGHT_ID")
	private Flight flight;

	@ManyToOne
	@JoinColumn(name = "PASS_ID")
	private Passenger passenger;

	public int getTicket_Price() {
		return ticket_Price;
	}

	public void setTicket_Price(int ticket_Price) {
		this.ticket_Price = ticket_Price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Ticket() {
	}

}