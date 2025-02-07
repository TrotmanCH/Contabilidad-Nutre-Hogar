package com.nutrehogar.sistemacontable.application;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.application.config.ConfigLoader;
import com.nutrehogar.sistemacontable.ui.JComponents.SplashScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {

    public static void main(String[] args) {
        System.setProperty("LOG_DIR", ConfigLoader.getLogsPath());
        Logger logger = LoggerFactory.getLogger(MainClass.class);
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);
        System.setProperty("flatlaf.animation", "true");
        System.setProperty("flatlaf.menuBarEmbedded", "true");
        System.setProperty("flatlaf.useWindowDecorations", "true");
        FlatLightLaf.setup();
        new App(splash);
    }
}
