package partTwo.clock;

public class Time {
    private int theHour = 0;
    private int theMinute = 0;
    private int theSecond = 0;

    protected String timeSet(int hour, int minute, int second){


        if(hour < 24 && hour>0)
            theHour = hour;
        else
            theHour = 99;
        if(minute < 60 && minute>0)
            theMinute = minute;
        else
            theMinute = 99;
        if(second < 60 && second>0)
            theSecond = second;
        else
            theSecond = 99;

        return showTime();
    }

    protected String showTime(){
        String returnValue = "";
        if(theHour < 10){
            returnValue+="0";
        }
        returnValue+=theHour+":";
        if(theMinute < 10){
            returnValue+="0";
        }
        returnValue+=theMinute+":";
        if(theSecond<10){
            returnValue+="0";
        }
        returnValue+=theSecond;
        return returnValue;
    }
}
