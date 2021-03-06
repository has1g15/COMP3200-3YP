package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tutorial {

    private String language, skill;
    private int currentIndex, tutorialID;
    private HashMap<String, String> tutorialData;
    private List<String> code, output, guides;

    public Tutorial(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
        currentIndex = 0;
        populateTutorialData();
        setCodeAndOutput();
        setGuides();
    }

    public void populateTutorialData()
    {
        tutorialID = DataHandler.dataHandler.getID(skill);
        tutorialData = DataHandler.dataHandler.getTutorialData(tutorialID, language);
    }

    public void setCodeAndOutput()
    {
        code = new ArrayList<>();
        output = new ArrayList<>();
        for (Map.Entry<String, String> entry: tutorialData.entrySet())
        {
            String temp[] = entry.getKey().split("\\$");
            code.add(temp[0]);
            output.add(temp[1]);
        }
    }

    public void setGuides()
    {
        guides = new ArrayList<>();
        for (Map.Entry<String, String> entry: tutorialData.entrySet())
        {
            guides.add(entry.getValue());
        }
    }

    public String getCurrentCode()
    {
        return code.get(currentIndex);
    }

    public String getCurrentOutput()
    {
        return output.get(currentIndex);
    }

    public String getCurrentGuide()
    {
        return guides.get(currentIndex);
    }

    public void incrementIndex()
    {
        currentIndex++;
    }

    public void decrementIndex()
    {
        currentIndex = currentIndex -1;
    }

    public boolean isMaxIndex()
    {
        return currentIndex == tutorialData.size();
    }

    public int getCurrentIndex()
    {
        return currentIndex;
    }

    public void saveProgress()
    {

    }

    public String getLanguage()
    {
        return language;
    }

    public String getSkill()
    {
        return skill;
    }
}
