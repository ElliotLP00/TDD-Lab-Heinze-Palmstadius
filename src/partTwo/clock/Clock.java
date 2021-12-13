package partTwo.clock;

public class Clock {
    private Time theTime = new Time();
    private Date theDate = new Date();
    public states state = states.DISPLAY_TIME;

    public String changeMode(){
        switch(state){
            case DISPLAY_TIME:
                    state = states.DISPLAY_DATE;
                    return theDate.showDate();
            case DISPLAY_DATE:
                    state = states.DISPLAY_TIME;
                    return theTime.showTime();
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

    public String ready(){
        switch(state){
            case DISPLAY_TIME:
                state = states.CHANGE_TIME;
                return "Ready to accept time";
            case DISPLAY_DATE:
                state = states.CHANGE_DATE;
                return "Ready to accept date";
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }

    public String set(int p1, int p2, int p3){
        switch(state){
            case CHANGE_TIME:
                state = states.DISPLAY_TIME;
                theTime.timeSet(p1,p2,p3);
                return theTime.showTime();
            case CHANGE_DATE:
                state = states.DISPLAY_DATE;
                theDate.dateSet(p1,p2,p3);
                return theDate.showDate();
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }
}
