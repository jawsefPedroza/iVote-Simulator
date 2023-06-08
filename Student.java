class Student {
    private String id; // Stores the ID of the student
    private String answer; // Stores the answer submitted by the student

    public Student(String id) {
        this.id = id; // Initialize the ID of the student
        this.answer = ""; // Initialize the answer as an empty string
    }

    public String getId() {
        return id; // Returns the ID of the student
    }

    public void submitAnswer(String answer) {
        this.answer = answer; // Sets the submitted answer for the student
    }

    public String getAnswer() {
        return answer; // Returns the answer submitted by the student
    }
}






