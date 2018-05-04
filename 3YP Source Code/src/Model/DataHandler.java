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
    private final String javaPracticalQuestions = "javaExercises";
    private final String javaScriptPracticalQuestions = "javaScriptExercises";
    private final String pythonPracticalQuestions = "pythonExercises";

    private SQLiteConnection c;

    public HashMap<String, HashMap<String, String>> appData;
    private HashMap<Integer, HashMap<String, String>> javaTutorialData, javaScriptTutorialData, pythonTutorialData,
                                                      javaMcqData, javaScriptMcqData, pythonMcqData,
                                                      javaExerciseData, javaScriptExerciseData, pythonExerciseData;
    public HashMap<String, Integer> skillMap;

    public static DataHandler dataHandler = new DataHandler();

    public void init()
    {
        c = new SQLiteConnection(new File(thirdYPdb));
        try
        {
            c.open(false);
        }
        catch (SQLiteException e)
        {
            error(e);
        }
        loadAppData();
        loadTutorialData();
        loadMcqData();
        loadPracticalQuestions();
        loadSkillMap();
        finish();
    }

    public void loadAppData()
    {
        System.out.println("Loading data from " + appDataTable);
        int count = 0;
        try
        {
            appData = new LinkedHashMap<>();
            SQLiteStatement stat = c.prepare("SELECT * FROM " + appDataTable);
            while (stat.step())
            {
                String language = stat.columnString(0);
                String dataField = stat.columnString(1);
                String data = stat.columnString(2);

                HashMap<String, String> datas = appData.get(language);

                if (datas == null)
                {
                    datas = new LinkedHashMap<>();
                    appData.put(language, datas);
                }
                datas.put(dataField, data);
                count++;
            }
            stat.dispose();
            System.out.println("Loaded " + count + " values");
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

        javaTutorialData = new LinkedHashMap<>();
        javaScriptTutorialData = new LinkedHashMap<>();
        pythonTutorialData = new LinkedHashMap<>();

        int count = 0;
        try
        {
            SQLiteStatement javaStat = c.prepare("SELECT * FROM " + javaTutorialTable);
            SQLiteStatement javaScriptStat = c.prepare("SELECT * FROM " + javaScriptTutorialTable);
            SQLiteStatement pythonStat = c.prepare("SELECT * FROM " + pythonTutorialTable);

            while (javaStat.step())
            {
                Integer tutorialID = javaStat.columnInt(0);
                String example = javaStat.columnString(1) + javaStat.columnString(2);
                String guide = javaStat.columnString(3);

                HashMap<String, String> tutorialContent = javaTutorialData.get(tutorialID);

                if (tutorialContent == null)
                {
                    tutorialContent = new LinkedHashMap<>();
                    javaTutorialData.put(tutorialID, tutorialContent);
                }
                tutorialContent.put(example, guide);
                count++;
            }

            javaStat.dispose();
            System.out.println("Loaded " + count + " tutorials pages from " + javaTutorialData.size() + " Java tutorials");
            count = 0;

            while (javaScriptStat.step())
            {
                Integer tutorialID = javaScriptStat.columnInt(0);
                String example = javaScriptStat.columnString(1) + javaScriptStat.columnString(2);
                String guide = javaScriptStat.columnString(3);

                HashMap<String, String> tutorialContent = javaScriptTutorialData.get(tutorialID);

                if (tutorialContent == null)
                {
                    tutorialContent = new LinkedHashMap<>();
                    javaScriptTutorialData.put(tutorialID, tutorialContent);
                }
                tutorialContent.put(example, guide);
                count++;
            }
            javaScriptStat.dispose();
            System.out.println("Loaded " + count + " tutorials from " + javaScriptTutorialData.size() + " JavaScript tutorials");
            count = 0;

            while (pythonStat.step())
            {
                Integer tutorialID = pythonStat.columnInt(0);
                String example = pythonStat.columnString(1) + pythonStat.columnString(2);
                String guide = pythonStat.columnString(3);

                HashMap<String, String> tutorialContent = pythonTutorialData.get(tutorialID);

                if(tutorialContent == null)
                {
                    tutorialContent = new LinkedHashMap<>();
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
        System.out.println("Loading data from " + javaScriptMcqTable);
        System.out.println("Loading data from " + pythonMcqTable);
        int count = 0;
        try
        {
            SQLiteStatement javaStat = c.prepare("SELECT * FROM " + javaMcqTable);
            SQLiteStatement javaScriptStat = c.prepare("SELECT * FROM " + javaScriptMcqTable);
            SQLiteStatement pythonStat = c.prepare("SELECT * FROM " + pythonMcqTable);

            javaMcqData = new LinkedHashMap<>();
            javaScriptMcqData = new LinkedHashMap<>();
            pythonMcqData = new LinkedHashMap<>();

            while (javaStat.step())
            {
                Integer mcqID = javaStat.columnInt(0);
                String questions = javaStat.columnString(1);
                String answers = javaStat.columnString(2) + javaStat.columnString(3) + javaStat.columnString(4) +
                        javaStat.columnString(5) + javaStat.columnString(6);

                HashMap<String, String> mcqQuestions = javaMcqData.get(mcqID);
                if (mcqQuestions == null)
                {
                    mcqQuestions = new LinkedHashMap<>();
                    javaMcqData.put(mcqID, mcqQuestions);
                }
                mcqQuestions.put(questions, answers);
                count++;
            }
            javaStat.dispose();
            System.out.println("Loaded " + count + " MCQs from " + javaMcqData.size() + " quizzes");
            count = 0;

            while (javaScriptStat.step())
            {
                Integer mcqID = javaScriptStat.columnInt(0);
                String questions = javaScriptStat.columnString(1);
                String answers = javaScriptStat.columnString(2) + javaScriptStat.columnString(3) + javaScriptStat.columnString(4) +
                        javaScriptStat.columnString(5) + javaScriptStat.columnString(6);

                HashMap<String, String> mcqQuestions = javaScriptMcqData.get(mcqID);
                if (mcqQuestions == null)
                {
                    mcqQuestions = new LinkedHashMap<>();
                    javaScriptMcqData.put(mcqID, mcqQuestions);
                }
                mcqQuestions.put(questions, answers);
                count++;
            }
            javaScriptStat.dispose();
            System.out.println("Loaded " + count + " MCQs from " + javaScriptMcqData.size() + " quizzes");
            count = 0;

            while (pythonStat.step())
            {
                Integer mcqID = pythonStat.columnInt(0);
                String questions = pythonStat.columnString(1);
                String answers = pythonStat.columnString(2) + pythonStat.columnString(3) + pythonStat.columnString(4) +
                        pythonStat.columnString(5) + pythonStat.columnString(6);

                HashMap<String, String> mcqQuestions = pythonMcqData.get(mcqID);
                if (mcqQuestions == null)
                {
                    mcqQuestions = new LinkedHashMap<>();
                    pythonMcqData.put(mcqID, mcqQuestions);
                }
                mcqQuestions.put(questions, answers);
                count++;
            }
            pythonStat.dispose();
            System.out.println("Loaded " + count + " MCQs from " + pythonMcqData.size() + " quizzes");
        }
        catch (SQLiteException e)
        {
            error(e);
        }
    }

    public void loadPracticalQuestions()
    {
        System.out.println("Loading data from " + javaPracticalQuestions);
        System.out.println("Loading data from " + javaScriptPracticalQuestions);
        System.out.println("Loading data from " + pythonPracticalQuestions);

        int count = 0;
        try
        {
            SQLiteStatement javaStat = c.prepare("SELECT * FROM " + javaPracticalQuestions);
            SQLiteStatement javaScriptStat = c.prepare("SELECT * FROM " + javaScriptPracticalQuestions);
            SQLiteStatement pythonStat = c.prepare("SELECT * FROM " + pythonPracticalQuestions);

            javaExerciseData = new LinkedHashMap<>();
            javaScriptExerciseData = new LinkedHashMap<>();
            pythonExerciseData = new LinkedHashMap<>();

            while (javaStat.step())
            {
                Integer exerciseID = javaStat.columnInt(0);
                String problem = javaStat.columnString(1);
                String answer = javaStat.columnString(2);

                HashMap<String, String> exercises = javaExerciseData.get(exerciseID);

                if (exercises == null)
                {
                    exercises = new LinkedHashMap<>();
                    javaExerciseData.put(exerciseID, exercises);
                }
                exercises.put(problem, answer);
                count++;
            }

            javaStat.dispose();
            System.out.println("Loaded " + javaExerciseData.size() + " Java exercises");
            count = 0;

            while (javaScriptStat.step())
            {
                Integer exerciseID = javaScriptStat.columnInt(0);
                String problem = javaScriptStat.columnString(1);
                String answer = javaScriptStat.columnString(2);

                HashMap<String, String> exercises = javaScriptExerciseData.get(exerciseID);

                if (exercises == null)
                {
                    exercises = new LinkedHashMap<>();
                    javaScriptExerciseData.put(exerciseID, exercises);
                }
                exercises.put(problem, answer);
                count++;
            }
            javaScriptStat.dispose();
            System.out.println("Loaded " + javaScriptExerciseData.size() + " JavaScript exercises");
            count = 0;

            while (pythonStat.step())
            {
                Integer exerciseID = pythonStat.columnInt(0);
                String problem = pythonStat.columnString(1);
                String answer = pythonStat.columnString(2);

                HashMap<String, String> exercises = pythonExerciseData.get(exerciseID);

                if (exercises == null)
                {
                    exercises = new LinkedHashMap<>();
                    pythonExerciseData.put(exerciseID, exercises);
                }
                exercises.put(problem, answer);
                count++;
            }
            pythonStat.dispose();
            System.out.println("Loaded " + pythonExerciseData.size() + " Python exercises");
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

    public void updateAppData(String language, String field, String data)
    {
        try
        {
            c = new SQLiteConnection(new File(thirdYPdb));
            c.open(false);
            c.exec("UPDATE appData SET data = '" + data + "' WHERE dataField = '" + field + "' AND language = '" + language + "';");
        }
        catch (SQLiteException e)
        {
            e.printStackTrace();
        }
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

    public HashMap<String, String> getExerciseData(int exerciseID, String language)
    {
        HashMap<Integer, HashMap<String, String>> map = null;
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
        return map.get(exerciseID);
    }

    public int getID(String skill)
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