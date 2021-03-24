package com.tneshcheret;

public class TimeSpan {
    private int hours;
    private int minutes;


    public TimeSpan(int hours, int minutes) {
        // minutes < 60
        if (minutes > 59) {
            throw new IllegalArgumentException("указано неверное количество минут");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(TimeSpan timeSpan) {
        this.minutes += timeSpan.minutes;
        this.hours += timeSpan.getHours();
        if (this.minutes >= 60) {
            this.hours += 1;
            this.minutes = this.minutes - 60;
        }

    }

    public void sub(TimeSpan timeSpan) {
        if (this.hours <= timeSpan.getHours() && this.minutes < timeSpan.minutes) {
            throw new IllegalArgumentException("указаны неверные парамметры");
        }
        this.hours = this.hours - timeSpan.hours;
        this.minutes = this.minutes - timeSpan.minutes;
        if (this.minutes < 0) {
            this.hours = this.hours - 1;
            this.minutes = 60 + this.minutes;
        }
    }

    public void mult(double times) {
        double multHours = this.hours * times;
        this.hours = (int) multHours;
        double less = multHours - this.hours;
        double lessMinutes = this.minutes + less * 60;
        double multMinutes = this.minutes * times + lessMinutes;
        this.minutes = (int) multMinutes;
        if (this.minutes >= 60) {
            this.hours += 1;
            this.minutes = this.minutes - 60;
        }
    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}
