package Model;

import java.util.Date;
import java.util.HashMap;

public class Progress {

    private HashMap<String, HashMap<Boolean, Date>> javaProgress, pythonProgress, javaScriptProgress;

    public Progress()
    {
        loadProgress();
    }

    public void loadProgress()
    {
        //TODO: load progress configuration from appData;
    }

    public void saveProgress()
    {
        //when user completes task or exits app, save progress to db by calling updateAppData()
    }
}
