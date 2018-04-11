package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tutorial {

    private String language, skill;
    private int currentIndex, tutorialID, maxIndex;
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
        System.out.print("populating");
        tutorialID = DataHandler.dataHandler.getTutorialID(skill);
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
            System.out.println(temp[0]);
            output.add(temp[1]);
        }
    }

    /*public void setOutputs()
    {
        output = new ArrayList<>();
        for (Map.Entry<String, String> entry: tutorialData.entrySet())
        {
            output.add(entry.getKey().split("\\$")[1]);
        }
    }*/

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
        System.out.print(code.get(currentIndex));
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
        currentIndex--;
    }

    public boolean isMaxIndex()
    {
        return maxIndex == tutorialData.size()-1;
    }

    public void saveProgress()
    {

    }
}
