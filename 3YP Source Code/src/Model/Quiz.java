package Model;

import java.util.*;

public class Quiz {

    private String language, skill;
    private List<String> questions;
    private List<String[]> answers;
    private String dateCompleted;
    private HashMap<String, String> quizData;
    private int quizID, quizScore;

    public Quiz(String language, String skill)
    {
        this.language = language;
        this.skill = skill;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        populateQuizData();
        setQuestions();
        setAnswers();
    }

    public void populateQuizData()
    {
        quizID = DataHandler.dataHandler.getQuizID(skill);
        quizData = DataHandler.dataHandler.getMCQData(quizID, language);
    }

    public List<String> getQuestions()
    {
        return questions;
    }

    public List<String[]> getAnswers()
    {
        return answers;
    }

    public void setQuestions()
    {
        for (String question: quizData.keySet())
        {
            questions.add(question);
        }
    }

    public void setAnswers()
    {
        for (Map.Entry<String, String> entry : quizData.entrySet())
        {
            System.out.println(entry.getValue());
            answers.add(entry.getValue().split("\\$"));

        }
    }

    public void setDateCompleted(String date)
    {
        dateCompleted = date;
    }

    public void setScore(int score)
    {
        quizScore = score;
    }
}
