package partTwo.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import partTwo.clock.Clock;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class clockTest {

    @BeforeEach
    void setUp(){
    }

    @Test
    void changeMode(){
        Clock clock = new Clock();
        Date date = new Date();
        int year = date.getYear() + 1900;
        String dateString = year + "-" + (date.getMonth()+1) + "-" + date.getDate();
        String returnValue = clock.changeMode();
        //assertEquals(dateString,returnValue);

        returnValue = clock.changeMode();
        String timeStirng = getTime();
        //assertEquals(timeStirng,returnValue);
    }

    @Test
    void ready() {
        Clock clock = new Clock();
        String returnValue = clock.ready();
    }

    @Test
    void set() {
        Clock clock = new Clock();
        String returnValue = clock.set(12,11,12);
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