package com.rot.app.answer;

public class AnswerDto {

    private Long id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private int answerNumber;
    private boolean one;
    private boolean two;
    private boolean three;
    private boolean four;
    private boolean five;

    public AnswerDto() {
    }

    public AnswerDto(Long id, String question, String answer1, String answer2, String answer3, String answer4, String answer5, int answerNumber) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answerNumber = answerNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(int answerNumber) {
        this.answerNumber = answerNumber;
    }

    public boolean isOne() {
        return one;
    }

    public void setOne(boolean one) {
        this.one = one;
    }

    public boolean isTwo() {
        return two;
    }

    public void setTwo(boolean two) {
        this.two = two;
    }

    public boolean isThree() {
        return three;
    }

    public void setThree(boolean three) {
        this.three = three;
    }

    public boolean isFour() {
        return four;
    }

    public void setFour(boolean four) {
        this.four = four;
    }

    public boolean isFive() {
        return five;
    }

    public void setFive(boolean five) {
        this.five = five;
    }

    public static Answer fromDto(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setId(answerDto.getId());
        answer.setQuestion(answerDto.getQuestion());
        answer.setAnswer1(answerDto.getAnswer1());
        answer.setAnswer2(answerDto.getAnswer2());
        answer.setAnswer3(answerDto.getAnswer3());
        answer.setAnswer4(answerDto.getAnswer4());
        answer.setAnswer5(answerDto.getAnswer5());
        if (answerDto.isOne()) {
            answer.setAnswerNumber(1);
        } else if (answerDto.isTwo()) {
            answer.setAnswerNumber(2);
        } else if (answerDto.isThree()) {
            answer.setAnswerNumber(3);
        } else if (answerDto.isFour()) {
            answer.setAnswerNumber(4);
        } else if (answerDto.isFive()) {
            answer.setAnswerNumber(5);
        }
        return answer;
    }

    public static AnswerDto fromEntity(Answer answer) {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setId(answer.getId());
        answerDto.setQuestion(answer.getQuestion());
        answerDto.setAnswer1(answer.getAnswer1());
        answerDto.setAnswer2(answer.getAnswer2());
        answerDto.setAnswer3(answer.getAnswer3());
        answerDto.setAnswer4(answer.getAnswer4());
        answerDto.setAnswer5(answer.getAnswer5());
        answerDto.setAnswerNumber(answer.getAnswerNumber());
        if (answer.getAnswerNumber() == 1) {
            answerDto.setOne(true);
        } else if (answer.getAnswerNumber() == 2) {
            answerDto.setTwo(true);
        } else if (answer.getAnswerNumber() == 3) {
            answerDto.setThree(true);
        } else if (answer.getAnswerNumber() == 4) {
            answerDto.setFour(true);
        } else if (answer.getAnswerNumber() == 5) {
            answerDto.setFive(true);
        }
        return answerDto;
    }
}


