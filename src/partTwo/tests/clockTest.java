package partTwo.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import partTwo.clock.Clock;
import partTwo.clock.states;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class clockTest {

    @BeforeEach
    void setUp(){
    }

    @Test
    void changeMode(){
        Clock clock = new Clock();
        assertEquals(clock.state,states.DISPLAY_TIME);
        Date date = new Date();
        String returnValue = clock.changeMode();
        assertEquals("2000-01-01",returnValue);
        assertEquals(clock.state,states.DISPLAY_DATE);

        returnValue = clock.changeMode();
        assertEquals("00:00:00",returnValue);
        assertEquals(clock.state,states.DISPLAY_TIME);
    }

    @Test
    void ready() {
        Clock clock = new Clock();
        assertEquals(clock.state,states.DISPLAY_TIME);
        String returnValue = clock.ready();
        assertEquals("Ready to accept time",returnValue);
        assertEquals(clock.state,states.CHANGE_TIME);
        clock = new Clock();
        clock.changeMode();
        assertEquals(clock.state,states.DISPLAY_DATE);
        returnValue = clock.ready();
        assertEquals("Ready to accept date",returnValue);
        assertEquals(clock.state,states.CHANGE_DATE);
    }

    @Test
    void set() {
        Clock clock = new Clock();
        clock.ready();
        assertEquals(clock.state,states.CHANGE_TIME);
        String returnValue = clock.set(12,27,5);
        assertEquals("12:27:05",returnValue);
        assertEquals(clock.state,states.DISPLAY_TIME);
        clock = new Clock();
        clock.changeMode();
        clock.ready();
        assertEquals(clock.state,states.CHANGE_DATE);
        returnValue = clock.set(2011,11,12);
        assertEquals("2011-11-12",returnValue);
        assertEquals(clock.state,states.DISPLAY_DATE);

        testBoundaries();
    }

    void testBoundaries(){
        Clock clock = new Clock();
        clock.ready();
        assertEquals(clock.state,states.CHANGE_TIME);
        //Fråga mange ang 99 som return value
        /** time min value test*/
        String returnValue = clock.set(-1,-1,-1);
        assertEquals("99:99:99",returnValue);
        /** time max value test*/
        clock.ready();
        returnValue = clock.set(25,60,60);
        assertEquals("99:99:99",returnValue);

        clock.changeMode();
        /** date min value test*/
        clock.ready();
        returnValue = clock.set(1999,0,0);
        assertEquals("9999-99-99",returnValue);
        /** date max value test*/
        clock.ready();
        returnValue = clock.set(2101,13,31);
        assertEquals("9999-99-99",returnValue);
    }
}