package com.company.tests;

import com.company.rovar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rovarTest {

    @BeforeEach
    void setUp() {
        System.out.print("new test - ");
    }

    @Test
    void enrov() {
        System.out.println("enröv");
        rovar r = new rovar();
        //Test null input
        String testOne = r.enrov(null);
        assertEquals(null,testOne);

        //Test empty-string
        String testTwo = r.enrov("");
        assertEquals("",testTwo);

        //Test non-empty-string
        String testThree = r.enrov("#hej!");
        assertEquals("#hohejoj!",testThree);

        testThree = r.enrov("0123456789");
        assertEquals("0123456789",testThree);

        testThree = r.enrov("abcdefghijklmnopqrstuvwxyzåäö");
        assertEquals("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö",testThree);

        testThree = r.enrov("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ");
        assertEquals("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ",testThree);

        testThree = r.enrov("ÖdlornasLiv 23?");
        assertEquals("ÖdodlolorornonasosLOLivov 23?",testThree);
    }

    @Test
    void derov() {
        System.out.println("deröv");
        rovar r = new rovar();
        //Test null input
        String testOne = r.derov(null);
        assertEquals(null,testOne);

        //Test empty-string
        String testTwo = r.derov("");
        assertEquals("",testTwo);

        //Test non-empty-string
        String testThree = r.derov("#hohejoj!");
        assertEquals("#hej!",testThree);

        testThree = r.derov("0123456789");
        assertEquals("0123456789",testThree);

        testThree = r.derov("abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzozåäö");
        assertEquals("abcdefghijklmnopqrstuvwxyzåäö",testThree);

        testThree = r.derov("ABOBCOCDODEFOFGOGHOHIJOJKOKLOLMOMNONOPOPQOQRORSOSTOTUVOVWOWXOXYZOZÅÄÖ");
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZÅÄÖ",testThree);

        testThree = r.derov("ÖdodlolorornonasosLOLivov 23?");
        assertEquals("ÖdlornasLiv 23?",testThree);
    }
}