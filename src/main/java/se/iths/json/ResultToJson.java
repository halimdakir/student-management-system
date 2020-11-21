package se.iths.json;

public class ResultToJson {
    private Number subjectAmount;

    public ResultToJson(Number subjectAmount) {
        this.subjectAmount = subjectAmount;
    }

    public Number getSubjectAmount() {
        return subjectAmount;
    }

    public void setSubjectAmount(Number subjectAmount) {
        this.subjectAmount = subjectAmount;
    }
}
