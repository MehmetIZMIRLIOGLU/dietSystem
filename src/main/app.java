package main;

import classes.Storage;
import screens.Main;

public class app
{
    public static void main(String[] args)
    {
        Storage.startProgram();
        // Open main screen
        new Main().setVisible(true);
    }
}
