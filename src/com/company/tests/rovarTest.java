package com.company.tests;

import com.company.rovar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rovarTest {

    @BeforeEach
    void setUp() {
        System.out.println("new test");
    }

    @Test
    void enrov() {
        rovar r = new rovar();
        //Test null input
        String testOne = r.enrov(null);
        assertEquals(null,testOne);

        //Test empty-string
        String testTwo = r.enrov("");
        assertEquals("",testTwo);

        //Test non-empty-string
        String testThree = r.enrov("rovar");
        assertEquals("rorovovaror",testThree);

        testThree = r.enrov("malmö");
        assertEquals("momalolmomö",testThree);

        testThree = r.enrov("OorDning");
        assertEquals("OororDODnoninongog",testThree);

        testThree = r.enrov("#hej!");
        assertEquals("#hohejoj!",testThree);

        testThree = r.enrov("#hej!");
        assertEquals("#hohejoj!",testThree);

        testThree = r.enrov("072 712 49 46");
        assertEquals("072 712 49 46",testThree);

        testThree = r.enrov("abcdefghijklmnopqrstuvwxyzåäö");
        assertEquals("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö",testThree);

        testThree = r.enrov("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ");
        assertEquals("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ",testThree);

        testThree = r.enrov("ÖdlornasLiv 23?");
        assertEquals("ÖdodlolorornonasosLOLivov 23?",testThree);
    }

    @Test
    void derov() {
    }
}