package com.nutrehogar.sistemacontable.application;
import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.application.config.ConfigLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainClass {

    public static void main(String[] args) {
        System.setProperty("LOG_DIR", ConfigLoader.getLogsPath());
        Logger logger = LoggerFactory.getLogger(MainClass.class);
        System.setProperty("flatlaf.useWindowDecorations", "true");
        FlatLightLaf.setup();

        new App();
    }
}
