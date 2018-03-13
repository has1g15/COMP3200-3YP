package Model;

import java.io.File;
import java.util.HashMap;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class DataHandler {

    /*
        TODO: build DB
        TODO: load methods for appData and longAnswer and tutorial
        TODO: update method for appData
        TODO: methods breaking down maps and returning question data
     */

    private final String thirdYPdb = "3YPdb";
    private final String appDataTable = "appData";
    private final String javaTutorialTable = "javaTutorial";
    private final String javaScriptTutorialTable = "javaScriptTutorial";
    private final String pythonTutorialTable = "pythonTutorial";
    private final String javaMcqTable = "javaMcq";
    private final String javaScriptMcqTable = "javaScriptMcq";
    private final String pythonMcqTable = "pythonMcq";
    private final String javaPracticalQuestions = "javaPractical";
    private final String javaScriptPracticalQuestions = "javaScriptPractical";
    private final String pythonPracticalQuestions = "pythonPractical";

    public SQLiteConnection c;

    private HashMap<String, String> appData;
    private HashMap<Integer, HashMap<String, String>> javaTutorialData, javaScriptTutorialData, pythonTutorialData,
                                                      javaMcqData, javaScriptMcqData, pythonMcqData,
                                                      javaExerciseData, javaScriptExerciseData, pythonExerciseData;
    private HashMap<String, Integer> skillMap;

    public static DataHandler dataHandler = new DataHandler();

    public void init()
    {
        c = new SQLiteConnection(new File(thirdYPdb));
        try
        {
            c.open(false);
            System.out.println("Opened database successfully");
        }
        catch (SQLiteException e)
        {
            error(e);
        }
        loadAppData();
        loadTutorialData();
        loadMcqData();
        loadSkillMap();
        finish();
    }

    public void loadAppData()
    {
        System.out.println("Loading data from " + appDataTable);
        int count = 0;
        try
        {
            SQLiteStatement stat = c.prepare("SELECT * FROM " + appDataTable);
            appData = new HashMap<>();
            while (stat.step())
            {
                String dataField = stat.columnString(0);
                String data = stat.columnString(1);
                appData.put(dataField, data);
                count++;
            }
            stat.dispose();
            System.out.println("Loaded " + count + " bits of data " + appData.size() + " app data");
        }
        catch (SQLiteException e)
        {
            error(e);
        }
    }

    public void loadTutorialData()
    {
        System.out.println("Loading data from " + javaTutorialTable);
        System.out.println("Loading data from " + javaScriptTutorialTable);
        System.out.println("Loading data from " + pythonTutorialTable);

        int count = 0;
        try
        {
            SQLiteStatement javaStat = c.prepare("SELECT * FROM " + javaTutorialTable);
            SQLiteStatement javaScriptStat = c.prepare("SELECT * FROM " + javaScriptTutorialTable);
            SQLiteStatement pythonStat = c.prepare("SELECT * FROM " + pythonTutorialTable);

            javaTutorialData = new HashMap<>();
            javaScriptTutorialData = new HashMap<>();
            pythonTutorialData = new HashMap<>();

            while (javaStat.step())
            {
                Integer tutorialID = javaStat.columnInt(0);
                String example = javaStat.columnString(1) + javaStat.columnString(2);
                String guide = javaStat.columnString(3);

                HashMap<String, String> tutorialContent = javaTutorialData.get(tutorialID);
                //Check if tutorial already exists otherwise create map for mcq
                if (tutorialContent == null)
                {
                    tutorialContent = new HashMap<>();
                    javaTutorialData.put(tutorialID, tutorialContent);
                }
                tutorialContent.put(example, guide);
                count++;
            }

            javaStat.dispose();
            System.out.println("Loaded " + count + " tutorials from " + javaTutorialData.size() + " Java tutorials");

            while (javaScriptStat.step())
            {
                Integer tutorialID = javaScriptStat.columnInt(0);
                String example = javaScriptStat.columnString(1) + javaScriptStat.columnString(2);
                String guide = javaScriptStat.columnString(3);

                HashMap<String, String> tutorialContent = javaScriptTutorialData.get(tutorialID);

                if (tutorialContent == null)
                {
                    tutorialContent = new HashMap<>();
                    javaScriptTutorialData.put(tutorialID, tutorialContent);
                }
                tutorialContent.put(example, guide);
                count++;
            }
            javaScriptStat.dispose();
            System.out.println("Loaded " + count + " tutorials from " + javaScriptTutorialData.size() + " JavaScript tutorials");

            while (pythonStat.step())
            {
                Integer tutorialID = pythonStat.columnInt(0);
                String example = pythonStat.columnString(1) + pythonStat.columnString(2);
                String guide = pythonStat.columnString(3);

                HashMap<String, String> tutorialContent = pythonTutorialData.get(tutorialID);

                if(tutorialContent == null)
                {
                    tutorialContent = new HashMap<>();
                    pythonTutorialData.put(tutorialID, tutorialContent);
                }
                tutorialContent.put(example, guide);
                count++;
            }
            pythonStat.dispose();
            System.out.println("Loaded " + count + " tutorials from " + javaScriptTutorialData.size() + " Python tutorials");
        }
        catch (SQLiteException e)
        {
            error(e);
        }
    }

    public void loadMcqData()
    {
        System.out.println("Loading data from " + javaMcqTable);
        int count = 0;
        try
        {
            SQLiteStatement stat = c.prepare("SELECT * FROM " + javaMcqTable);
            javaMcqData = new HashMap<>();
            while (stat.step())
            {
                Integer mcqID = stat.columnInt(0);
                String question = stat.columnString(1);
                String answers = stat.columnString(2) + stat.columnString(3) + stat.columnString(4) + stat.columnString(5);

                HashMap<String, String> mcqQuestions = javaMcqData.get(mcqID);
                //Check if mcq already exists otherwise create map for mcq
                if (mcqQuestions == null)
                {
                    mcqQuestions = new HashMap<>();
                    javaMcqData.put(mcqID, mcqQuestions);
                }
                mcqQuestions.put(question, answers);
                count++;
            }

            stat.dispose();
            System.out.println("Loaded " + count + " MCQs from " + javaMcqData.size() + " quizzes");
        }
        catch (SQLiteException e)
        {
            error(e);
        }
    }

    public void loadPracticalQuestions()
    {

    }

    public void loadSkillMap()
    {
        skillMap = new HashMap<>();
        skillMap.put("Printing, Variable Declaration and Data Types", 1);
        skillMap.put("Formatting and I/O", 2);
        skillMap.put("Conditional Statements", 3);
        skillMap.put("Loops", 4);
        skillMap.put("Operators", 5);
        skillMap.put("String Handling", 6);
        skillMap.put("Functions, Procedures and Libraries", 7);
        skillMap.put("Scope", 8);
        skillMap.put("Data Structures", 9);
        skillMap.put("Searching and Sorting", 10);
    }

    public void updateAppData(String field, String data)
    {

    }

    public HashMap<String, String> getAppData()
    {
        return appData;
    }

    public HashMap<String, String> getMCQData(int quizID, String language)
    {
        HashMap<Integer, HashMap <String, String>> map = null;
        switch (language)
        {
            case "Java":
                map = javaMcqData;
                break;
            case "JavaScript":
                map = javaScriptMcqData;
                break;
            case "Python":
                map = pythonMcqData;
                break;
        }
        return map.get(quizID);
    }

    public void getExerciseData()
    {

    }

    public int getQuizID(String skill)
    {
        return skillMap.get(skill);
    }

    public void error(SQLiteException e)
    {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }

    public void finish()
    {
        c.dispose();
    }
}