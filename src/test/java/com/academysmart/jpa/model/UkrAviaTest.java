package com.academysmart.jpa.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UkrAviaTest {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("derbyTest");
	private EntityManager em;
	private EntityTransaction tx;

	@Before
	public void setUp() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@After
	public void tearDown() throws Exception {
		if (em != null) {
			em.clear();
		}
	}

	@Test
	public void showFindTicket() throws Exception {
		Ticket ticket = em.find(Ticket.class, 4L);
		assertEquals(4, ticket.getId());

	}

	@Test
	public void showFindPassenger() throws Exception {
		Passenger passenger = em.find(Passenger.class, 1L);
		assertEquals("IRYNA", passenger.getName());

	}

	public void shouldCreatePassenger() {
		Passenger passenger = new Passenger();
		passenger.setPassId(10);
		passenger.setName("OLEG");
		passenger.setSurname("PETROV");
		passenger.setPatronymic("ALEKSEEVICH");
		passenger.setPhone("7656756");
		tx.begin();
		em.persist(passenger);
		tx.commit();
		em.close();

	}

}