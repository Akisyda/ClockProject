package org.example;

import javax.swing.*;
import java.awt.*;

public class Main2 {
    private static final int PERIOD_MS = 100;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main2::createAndShow);
    }

    private static void createAndShow() {
        ClockExt2 clock = new ClockExt2(0, 0, 0, 0);

        JFrame frame = new JFrame("Електронний годинник");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 4, 10, 5));

        Font numFont = new Font("Monospaced", Font.BOLD, 40);
        Font capFont = new Font("SansSerif", Font.PLAIN, 14);
        String[] captions = {"Години", "Хвилини", "Секунди", "Мілісекунди"};
        for (String c : captions) {
            JLabel l = new JLabel(c, SwingConstants.CENTER);
            l.setFont(capFont);
            frame.add(l);
        }
        JLabel hLabel = new JLabel("00", SwingConstants.CENTER);
        JLabel mLabel = new JLabel("00", SwingConstants.CENTER);
        JLabel sLabel = new JLabel("00", SwingConstants.CENTER);
        JLabel msLabel = new JLabel("000", SwingConstants.CENTER);
        for (JLabel l : new JLabel[]{hLabel, mLabel, sLabel, msLabel}) {
            l.setFont(numFont);
            frame.add(l);
        }

        // Таймер: кожні 100 мс додає 100 мс до годинника й оновлює вікно
        Timer timer = new Timer(PERIOD_MS, e -> {
            clock.advance(PERIOD_MS);
            hLabel.setText(String.format("%02d", clock.getHours()));
            mLabel.setText(String.format("%02d", clock.getMinutes()));
            sLabel.setText(String.format("%02d", clock.getSeconds()));
            msLabel.setText(String.format("%03d", clock.getMilliseconds()));
        });
        timer.start();

        frame.setSize(600, 160);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
