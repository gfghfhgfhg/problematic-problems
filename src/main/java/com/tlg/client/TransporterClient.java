package com.tlg.client;

import com.tlg.gui.MainWindow;
import com.tlg.util.*;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TransporterClient {
    public static MainWindow mainWindow;
    public static void main(String[] args) throws IOException, InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            /**
             * run() - Override creates a new instance of our main window class.
             */
            @Override
            public void run() {
                mainWindow = new MainWindow();
                mainWindow.show();
            }
        });
        //shows the title screen and introduction
        TitleScreen start = new TitleScreen();
        start.titleScreen();
        start.intro();
        //initializes input handling and calls the gameStart method to start new game or quit
        InputHandling gameStart = new InputHandling();
        try {
            gameStart.gameStart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
