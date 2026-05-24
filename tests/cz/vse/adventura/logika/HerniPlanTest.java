package cz.vse.adventura.logika;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HerniPlanTest {

    private HerniPlan plan;

    @BeforeEach
    void setUp() {
        plan = new HerniPlan();
    }

    @Test
    void getAktualniProstor() {
        assertNotNull(plan.getAktualniProstor());
        assertEquals("vchod", plan.getAktualniProstor().getNazev());
    }

    @Test
    void getHrdina() {
        assertNotNull(plan.getHrdina());
        assertEquals("Hrdina", plan.getHrdina().getJmeno());
    }

    @Test
    void getDrakSmak() {
        assertNotNull(plan.getDrakSmak());
        assertEquals("Šmak", plan.getDrakSmak().getJmeno());
    }

    @Test
    void getBatoh() {
        assertNotNull(plan.getBatoh());
    }
}