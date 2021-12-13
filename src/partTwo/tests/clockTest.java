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
        int year = date.getYear() + 1900;
        String dateString = year + "-" + (date.getMonth()+1) + "-" + date.getDate();
        String returnValue = clock.changeMode();
        assertEquals(dateString,returnValue);
        assertEquals(clock.state,states.DISPLAY_DATE);

        returnValue = clock.changeMode();
        String timeStirng = getTime();
        assertEquals(timeStirng,returnValue);
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
        String returnValue = clock.set(12,27,05);
        assertEquals("12:27:05",returnValue);
        assertEquals(clock.state,states.DISPLAY_TIME);
        clock = new Clock();
        clock.changeMode();
        clock.ready();
        assertEquals(clock.state,states.CHANGE_DATE);
        returnValue = clock.set(2011,11,12);
        assertEquals("2011-11-12",returnValue);
        assertEquals(clock.state,states.DISPLAY_DATE);
    }

    private String getTime(){
        Date date = new Date();
        String time = date.getHours()+":";

        int min = date.getMinutes();
        if(min < 10) {
            time += "0";
        }
        time+=min+":";

        int sec = date.getSeconds();
        if(sec < 10) {
            time += "0";
        }
        time+=sec;
        return time;
    }
}