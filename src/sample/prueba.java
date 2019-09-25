package sample;

public class prueba {
    String expected,run,status;

    public prueba(String expected, String run, String status) {
        this.expected = expected;
        this.run = run;
        this.status = status;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
