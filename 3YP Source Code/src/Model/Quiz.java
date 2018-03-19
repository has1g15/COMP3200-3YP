package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Quiz {

    private String language, skill;
    private List<String> questions, answers;
    private Date dateCompleted;
    private HashMap<String, String> quizData;
    private int quizID, score;

    public Quiz(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
        questions = new ArrayList<>();
        answers = new ArrayList();
        //populateQuizData();
    }

    public void populateQuizData()
    {
        quizID = DataHandler.dataHandler.getQuizID(skill);
        quizData = DataHandler.dataHandler.getMCQData(quizID, language);
        //TODO: populate question and answer lists from DataHandler using MCQ ID
    }

    public String getQuestion(int index)
    {
        return questions.get(index-1);
    }

    public String[] getAnswers(int index)
    {
        return answers.get(index-1).split("$");
    }

    public void setQuestions()
    {

    }

    public void setAnswers()
    {

    }
}
