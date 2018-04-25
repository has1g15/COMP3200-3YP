package Model;

import View.MainFrame;
import com.almworks.sqlite4java.SQLiteException;

import java.util.Date;
import java.util.HashMap;

public class Progress {

    private int pointsToAdd, points;
    //private DataHandler dataHandler;

    public Progress()
    {

    }

    public Progress(String language, String field, String value)
    {
        //dataHandler = new DataHandler();
        saveProgress(language, field, value);
    }

    public void saveProgress(String language, String field, String value)
    {
        if (calculatePoints(language, field, value) == true)
        {
            points = Integer.parseInt(DataHandler.dataHandler.getAppData(language).get("Points")) + pointsToAdd;
            DataHandler.dataHandler.updateAppData(language, field, value);
            DataHandler.dataHandler.updateAppData(language, "Points", String.valueOf(points));
            DataHandler.dataHandler.updateAppData(language, "Percentage", calculatePercentage());
            DataHandler.dataHandler.updateAppData(language, "Level", calculateLevel());
            MainFrame.mainFrame.updateProgressBars();
        }
    }

    public boolean calculatePoints(String language, String field, String points)
    {
        int addition;
        System.out.print(language + field);
        int prevValue = Integer.parseInt(DataHandler.dataHandler.getAppData(language).get(field));
        boolean more;
        if (prevValue < Integer.parseInt(points))
        {
            addition = Integer.parseInt(points) - prevValue;
            setPoints(addition);
            more = true;
        }
        else
        {
            more = false;
        }
        return more;
    }

    public void setPoints(int points)
    {
        pointsToAdd = points;
    }

    public String calculatePercentage()
    {
        int percentage = points/200;
        return String.valueOf(percentage);
    }

    public String calculateLevel()
    {
        int level = 0;
        if (points < 40)
        {
            level = 0;
        }
        else if (points >= 40 && points < 80)
        {
            level = 1;
        }
        else if (points >= 80 && points < 120)
        {
            level = 2;
        }
        else if (points >- 120 && points < 160)
        {
            level = 3;
        }
        else if (points >= 160 && points < 200)
        {
            level = 4;
        }
        else if (points == 200)
        {
            level = 5;
        }
        return String.valueOf(level);
    }

    public int getJavaPercentage()
    {
        return Integer.parseInt(DataHandler.dataHandler.getAppData("Java").get("Progress"));
    }

    public int getJavaScriptPercentage()
    {
        return Integer.parseInt(DataHandler.dataHandler.getAppData("JavaScript").get("Progress"));
    }

    public int getPythonPercentage()
    {
        return Integer.parseInt(DataHandler.dataHandler.getAppData("Python").get("Progress"));
    }
}
