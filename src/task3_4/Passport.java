package task3_4;

public class Passport {
    public String series;
    public String number;

    public Passport(String series, String number)
    {
        this.series = series;
        this.number = number;
    }

    public String getFullId() {
        return this.series + this.number;
    }
}
