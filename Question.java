import java.util.List;

public class Question {
    private String type; // Stores the type of the question
    private List<String> candidateAnswers; // Stores the list of candidate answers for the question

    public Question(String type, List<String> candidateAnswers) {
        this.type = type; // Initialize the type of the question
        this.candidateAnswers = candidateAnswers; // Initialize the list of candidate answers
    }

    public String getType() {
        return type; // Returns the type of the question
    }

    public List<String> getCandidateAnswers() {
        return candidateAnswers; // Returns the list of candidate answers for the question
    }
}