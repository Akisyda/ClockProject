package org.example;

// Базовий клас: годинник із годинами, хвилинами і секундами
public class Clock {
    protected int hours;
    protected int minutes;
    protected int seconds;

    public Clock() {
        this(0, 0, 0);
    }

    public Clock(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
    public int getSeconds() { return seconds; }

    public void setHours(int hours) {
        if (hours < 0 || hours > 23) throw new IllegalArgumentException("Години: 0-23");
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) throw new IllegalArgumentException("Хвилини: 0-59");
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) throw new IllegalArgumentException("Секунди: 0-59");
        this.seconds = seconds;
    }

    // Збільшує час на 1 секунду з переносом у хвилини та години
    public void nextSecond() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
