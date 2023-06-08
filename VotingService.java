import java.util.*;

public class VotingService {
    private Question question;
    private Map<String, Student> submissions;

    public VotingService(Question question) {
        this.question = question;
        this.submissions = new HashMap<>();
    }

    public void submitAnswer(Student student, String answer) {
        if (submissions.containsKey(student.getId())) {
            // If the student has already submitted, update their answer
            Student existingStudent = submissions.get(student.getId());
            existingStudent.submitAnswer(answer);
        } else {
            // Add a new submission
            student.submitAnswer(answer);
            submissions.put(student.getId(), student);
        }
    }

    public void displayResult() {
        Map<String, Integer> answerCounts = new HashMap<>();

        // Initialize answer counts
        for (String answer : question.getCandidateAnswers()) {
            answerCounts.put(answer, 0);
        }

        // Count the submissions
        for (Student student : submissions.values()) {
            String answer = student.getAnswer();
            if (answerCounts.containsKey(answer)) {
                int count = answerCounts.get(answer);
                answerCounts.put(answer, count + 1);
            }
        }

        // Print the result
        for (Map.Entry<String, Integer> entry : answerCounts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
