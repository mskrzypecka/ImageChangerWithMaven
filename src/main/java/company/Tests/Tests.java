package company.Tests;

import company.MainJFrame;

import java.awt.*;

public class Tests {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainJFrame();
            }
        });
    }
}