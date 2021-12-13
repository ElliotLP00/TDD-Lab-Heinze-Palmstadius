package partTwo.clock;

public class Date {
    private int theYear = 2000;
    private int theMonth = 1;
    private int theDay = 1;

    protected String dateSet(int year, int month, int day){

        if(year <= 2100 && year>=2000)
            theYear = year;
        else
            theYear = 9999;
        if(month <= 12 && month>=1)
            theMonth = month;
        else
            theMonth = 99;
        if(day <= 30 && day>=1)
            theDay = day;
        else
            theDay=99;

        return showDate();
    }

    protected String showDate(){
        String returnValue = ""+theYear+"-";
        if(theMonth < 10){
            returnValue+="0";
        }
        returnValue+=theMonth+"-";
        if(theDay<10){
            returnValue+="0";
        }
        returnValue+=theDay;
        return returnValue;
    }
}
