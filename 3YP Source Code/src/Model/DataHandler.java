package Model;

import java.io.File;
import java.util.*;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class DataHandler {

    private final String thirdYPdb = "3YPdb.db";
    private final String appDataTable = "appData";
    private final String javaTutorialTable = "javaTutorials";
    private final String javaScriptTutorialTable = "javaScriptTutorials";
    private final String pythonTutorialTable = "pythonTutorials";
    private final String javaMcqTable = "javaMcq";
    private final String javaScriptMcqTable = "javaScriptMcq";
    private final String pythonMcqTable = "pythonMcq";
    private final String javaPracticalQuestions = "javaPractical";
    private final String javaScriptPracticalQuestions = "javaScriptPractical";
    private final String pythonPracticalQuestions = "pythonPractical";

    public SQLiteConnection c;

    private HashMap<String, HashMap<String, String>> appData;
    private HashMap<Integer, HashMap<String, String>> javaTutorialData, javaScriptTutorialData, pythonTutorialData,
                                                      javaMcqData, javaScriptMcqData, pythonMcqData;
    private HashMap<Integer, String> javaExerciseData, javaScriptExerciseData, pythonExerciseData;
    private HashMap<String, Integer> skillMap;

    public static DataHandler dataHandler = new DataHandler();

    public void init()
    {
        System.out.println(thirdYPdb);
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
        //loadPracticalQuestions();
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
                String language = stat.columnString(0);
                String dataField = stat.columnString(1);
                String data = stat.columnString(2);

                HashMap<String, String> datas = appData.get(language);
                //Check if tutorial already exists otherwise create map for mcq
                if (datas == null)
                {
                    datas = new LinkedHashMap<>();
                    appData.put(language, datas);
                }
                datas.put(dataField, data);
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
        //System.out.println("Loading data from " + javaScriptTutorialTable);
        //System.out.println("Loading data from " + pythonTutorialTable);

        int count = 0;
        try
        {
            SQLiteStatement javaStat = c.prepare("SELECT * FROM " + javaTutorialTable);
            //SQLiteStatement javaScriptStat = c.prepare("SELECT * FROM " + javaScriptTutorialTable);
            //SQLiteStatement pythonStat = c.prepare("SELECT * FROM " + pythonTutorialTable);

            javaTutorialData = new LinkedHashMap<>();
            //javaScriptTutorialData = new HashMap<>();
            //pythonTutorialData = new HashMap<>();

            while (javaStat.step())
            {
                Integer tutorialID = javaStat.columnInt(0);
                String example = javaStat.columnString(1) + javaStat.columnString(2);
                String guide = javaStat.columnString(3);

                HashMap<String, String> tutorialContent = javaTutorialData.get(tutorialID);
                //Check if tutorial already exists otherwise create map for mcq
                if (tutorialContent == null)
                {
                    tutorialContent = new LinkedHashMap<>();
                    javaTutorialData.put(tutorialID, tutorialContent);
                }
                tutorialContent.put(example, guide);
                count++;
            }

            javaStat.dispose();
            System.out.println("Loaded " + count + " tutorials from " + javaTutorialData.size() + " Java tutorials");

            /*while (javaScriptStat.step())
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
            System.out.println("Loaded " + count + " tutorials from " + javaScriptTutorialData.size() + " Python tutorials");*/
        }
        catch (SQLiteException e)
        {
            error(e);
        }
    }

    public void loadMcqData()
    {
        System.out.println("Loading data from " + javaMcqTable);
        //System.out.println("Loading data from " + javaScriptMcqTable);
        //System.out.println("Loading data from " + pythonMcqTable);
        int count = 0;
        try
        {
            SQLiteStatement stat = c.prepare("SELECT * FROM " + javaMcqTable);
            javaMcqData = new LinkedHashMap<>();
            while (stat.step())
            {
                Integer mcqID = stat.columnInt(0);
                String questions = stat.columnString(1);
                String answers = stat.columnString(2) + stat.columnString(3) + stat.columnString(4) +
                        stat.columnString(5) + stat.columnString(6);

                HashMap<String, String> mcqQuestions = javaMcqData.get(mcqID);
                //Check if mcq already exists otherwise create map for mcq
                if (mcqQuestions == null)
                {
                    mcqQuestions = new LinkedHashMap<>();
                    javaMcqData.put(mcqID, mcqQuestions);
                }
                mcqQuestions.put(questions, answers);
                count++;
            }

            stat.dispose();
            System.out.println("Loaded " + count + " MCQs from " + javaMcqData.size() + " quizzes");
            System.out.print(javaMcqData.toString());
        }
        catch (SQLiteException e)
        {
            error(e);
        }
    }

    public void loadPracticalQuestions()
    {
        System.out.println("Loading data from " + javaPracticalQuestions);
        //System.out.println("Loading data from " + javaScriptPracticalQuestions);
        //System.out.println("Loading data from " + pythonPracticalQuestions);

        int count = 0;
        try
        {
            SQLiteStatement javaStat = c.prepare("SELECT * FROM " + javaPracticalQuestions);
            SQLiteStatement javaScriptStat = c.prepare("SELECT * FROM " + javaScriptPracticalQuestions);
            SQLiteStatement pythonStat = c.prepare("SELECT * FROM " + pythonPracticalQuestions);

            //change hashmaps to multimaps/add extra field for ordered answers
            javaExerciseData = new LinkedHashMap<>();
            //javaScriptExerciseData = new LinkedHashMap<>();
            //pythonExerciseData = new LinkedHashMap<>();

            while (javaStat.step())
            {
                Integer exerciseID = javaStat.columnInt(0);
                String codeLine = javaStat.columnString(1);
                javaExerciseData.put(exerciseID, codeLine);
                count++;
            }

            javaStat.dispose();
            System.out.println("Loaded " + count + " exercises from " + javaExerciseData.size() + " Java exercises");

            /*while (javaScriptStat.step())
            {
                Integer exerciseID = javaStat.columnInt(0);
                String codeLine = javaStat.columnString(1);
                javaScriptExerciseData.put(exerciseID, codeLine);
                count++;
            }
            javaScriptStat.dispose();
            System.out.println("Loaded " + count + " exercises from " + javaScriptExerciseData.size() + " JavaScript exercises");

            while (pythonStat.step())
            {
                Integer exerciseID = javaStat.columnInt(0);
                String codeLine = javaStat.columnString(1);
                pythonExerciseData.put(exerciseID, codeLine);
                count++;
            }
            pythonStat.dispose();
            System.out.println("Loaded " + count + " exercises from " + pythonExerciseData.size() + " Python exercises");*/
        }
        catch (SQLiteException e)
        {
            error(e);
        }
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
        skillMap.put("File Handling", 10);
    }

    public void updateAppData(String field, String data)
    {

    }

    public HashMap<String, String> getAppData(String language)
    {
        return appData.get(language);
    }

    public HashMap<String, String> getTutorialData(int tutorialID, String language)
    {
        HashMap<Integer, HashMap <String, String>> map = null;
        switch (language)
        {
            case "Java":
                map = javaTutorialData;
                break;
            case "JavaScript":
                map = javaScriptTutorialData;
                break;
            case "Python":
                map = pythonTutorialData;
                break;
        }
        return map.get(tutorialID);
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

    public List<String> getExerciseData(int exerciseID, String language)
    {
        HashMap<Integer, String> map = null;
        switch (language)
        {
            case "Java":
                map = javaExerciseData;
                break;
            case "JavaScript":
                map = javaScriptExerciseData;
                break;
            case "Python":
                map = pythonExerciseData;
                break;
        }
        List<String> codeLines = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : map.entrySet())
        {
            if (exerciseID == entry.getKey())
            {
                codeLines.add(entry.getValue());
            }
        }
        return codeLines;
    }

    public int getTutorialID(String skill)
    {
        return skillMap.get(skill);
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