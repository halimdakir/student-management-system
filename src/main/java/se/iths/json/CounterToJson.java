package se.iths.json;

public class CounterToJson {
    private Number subjectAmount;

    public CounterToJson(Number subjectAmount) {
        this.subjectAmount = subjectAmount;
    }

    public Number getSubjectAmount() {
        return subjectAmount;
    }

    public void setSubjectAmount(Number subjectAmount) {
        this.subjectAmount = subjectAmount;
    }
}
