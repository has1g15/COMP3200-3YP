package Model;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class DataHandler {

    /*
        TODO: build DB
        TODO: load methods for appData and longAnswer
        TODO: update method for appData
        TODO: methods breaking down maps and returning question data
     */

    final String DBName = "appData";
    final String mcqTable = "mcq";
    final String practicalQuestions = "longAnswer";
    public SQLiteConnection c;

    private HashMap<Integer, HashMap<String, String>> data;

    public static DataHandler dataHandler = new DataHandler();

    public void init() {
        c = new SQLiteConnection(new File(DBName));
        try {
            c.open(false);
            System.out.println("Opened database successfully");
        } catch (SQLiteException e) {
            error(e);
        }
        loadMcqData();
        finish();
    }

    public void loadAppData() {

    }

    public void loadMcqData() {
        System.out.println("Loading data from " + mcqTable);
        int count = 0;
        try {
            SQLiteStatement stat = c.prepare("SELECT * FROM " + mcqTable);

            data = new HashMap<>();
            while (stat.step()) {
                Integer mcqID = stat.columnInt(0);
                String question = stat.columnString(1);
                String answer = stat.columnString(2);

                HashMap<String, String> mcqQuestions = data.get(mcqID);
                //Check if mcq already exists otherwise create map for mcq
                if (mcqQuestions == null) {
                    mcqQuestions = new HashMap<>();
                    data.put(mcqID, mcqQuestions);
                }
                mcqQuestions.put(question, answer);
                count++;
            }

            stat.dispose();
            System.out.println("Loaded " + count + " MCQs from " + data.size() + " quizzes");
        } catch (SQLiteException e) {
            error(e);
        }
    }

    public void loadLongAnswer() {

    }

    public void updateAppData()
    {

    }

    public void error(SQLiteException e) {
        System.err.println(e.getClass().getName() + ": " + e.getMessage());
        System.exit(0);
    }

    public void finish() {
        c.dispose();
    }
}