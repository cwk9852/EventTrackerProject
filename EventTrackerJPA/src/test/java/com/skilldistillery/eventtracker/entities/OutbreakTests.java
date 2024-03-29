package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutbreakTests {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Outbreak outbreak;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTrackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		outbreak = em.find(Outbreak.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		outbreak = null;
	}

	@Test
	@DisplayName(value = "Outbreak Mappings Test")
	void test_Dummy_mappings() {
		assertNotNull(outbreak);
		assertEquals(1, outbreak.getId());
		assertEquals("Other Animal Disease",outbreak.getDisease());
	}
	
}