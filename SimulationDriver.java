import java.util.*;

class SimulationDriver {
    private static Random random = new Random();

    public static void main(String[] args) {
        // Create the first multiple-choice question
        List<String> candidateAnswersSC = Arrays.asList("Right", "Wrong");
        Question questionSC = new Question("Single-choice", candidateAnswersSC);

        // Configure the question for the voting service
        VotingService votingService2 = new VotingService(questionSC);

        // Generate students
        List<Student> students = generateStudents(34);

        // Generate answers for the single-choice question
        generateAnswers(students, candidateAnswersSC);

        System.out.println("\nWhat is the capital of France?");
        System.out.println("Students' Answers:");

        // Submit the answers to the voting service
        for (Student student : students) {
            votingService2.submitAnswer(student, student.getAnswer());
        }

        // Display the result
        votingService2.displayResult();

        System.out.println();

        // Create a question
        List<String> candidateAnswers = Arrays.asList("A", "B", "C", "D");
        Question questionMC = new Question("Multiple-choice", candidateAnswers);

        // Configure the question for the voting service
        VotingService votingService = new VotingService(questionMC);

        // Generate answers for the multiple-choice question
        generateAnswers(students, candidateAnswers);

        System.out.println("What is 6 / 2 (1+2)?");
        System.out.println("A. 9\nB. 6\nC. 1\nD. 4");
        System.out.println("Students' Answers:");

        // Submit the answers to the voting service
        for (Student student : students) {
            votingService.submitAnswer(student, student.getAnswer());
        }

        // Display the result
        votingService.displayResult();
    }

    private static List<Student> generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String id = "Student" + i;
            students.add(new Student(id));
        }
        return students;
    }

    private static void generateAnswers(List<Student> students, List<String> candidateAnswers) {
        for (Student student : students) {
            int index = random.nextInt(candidateAnswers.size());
            String answer = candidateAnswers.get(index);
            student.submitAnswer(answer);
        }
    }
}