package Model;

import View.MainFrame;

import java.util.Date;
import java.util.HashMap;

public class Progress {

    private int pointsToAdd;

    String language, field, value;

    public Progress(String language, String field, String value)
    {
        this.language = language;
        this.field = field;
        this.value = value;
        saveProgress();
    }

    public void saveProgress()
    {
        if (calculatePoints(language, field, value) == true)
        {
            DataHandler.dataHandler.updateAppData(language, field, value);
            //DataHandler.dataHandler.updateAppData(language, "Points", current points from data handler + points to add);
            DataHandler.dataHandler.updateAppData(language, "Percentage", "2");
            DataHandler.dataHandler.updateAppData(language, "Level", "3");
            MainFrame.mainFrame.updateProgressBars();
        }
    }

    public boolean calculatePoints(String language, String field, String points)
    {
        int addition;
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

    public int calculatePercentage()
    {
        int percentage = 0;
        return percentage;
    }

    public int calculateLevel()
    {
        //switch on current points values
        int percentage = 0;
        return percentage;
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
