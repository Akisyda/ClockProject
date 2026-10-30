package org.example;

// Розширений годинник: додає крок на хвилину і на годину
public class ClockExt extends Clock {

    public ClockExt() {
        super();
    }

    public ClockExt(int hours, int minutes, int seconds) {
        super(hours, minutes, seconds);
    }

    public void nextMinute() {
        for (int i = 0; i < 60; i++) {
            nextSecond();
        }
    }

    public void nextHour() {
        for (int i = 0; i < 60; i++) {
            nextMinute();
        }
    }
}
