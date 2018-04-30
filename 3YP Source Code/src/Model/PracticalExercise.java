package Model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PracticalExercise {

    private String language, skill, problem, answer;
    private int exerciseID;
    private HashMap<String, String> exerciseData;

    public PracticalExercise(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
        populateExerciseData();
    }

    public void populateExerciseData()
    {
        exerciseID = DataHandler.dataHandler.getID(skill);
        exerciseData = DataHandler.dataHandler.getExerciseData(exerciseID, language);
        Iterator it = exerciseData.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry entry = (Map.Entry)it.next();
            problem = (String)entry.getKey();
            answer = (String)entry.getValue();
        }
        System.out.print(problem);
        System.out.println(answer);
    }

    public String getProblem()
    {
        return problem;
    }

    public String getAnswer()
    {
        return answer;
    }
}
