package org.example;

public class ClockExt2 extends ClockExt {
    private int milliseconds;

    public ClockExt2() {
        super();
        this.milliseconds = 0;
    }

    public ClockExt2(int hours, int minutes, int seconds, int milliseconds) {
        super(hours, minutes, seconds);
        setMilliseconds(milliseconds);
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        if (milliseconds < 0 || milliseconds > 999) {
            throw new IllegalArgumentException("Мілісекунди мають бути від 0 до 999");
        }
        this.milliseconds = milliseconds;
    }

    // Додає 1 мс; при переповненні (1000 мс) збільшує секунду
    public void nextMillisecond() {
        milliseconds++;
        if (milliseconds == 1000) {
            milliseconds = 0;
            nextSecond();
        }
    }

    // Крок таймера: додає ms мілісекунд (для таймера 100 мс)
    public void advance(int ms) {
        for (int i = 0; i < ms; i++) {
            nextMillisecond();
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d.%03d", getHours(), getMinutes(), getSeconds(), milliseconds);
    }
}
