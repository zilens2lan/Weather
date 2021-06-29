package com.zilen.weather;

import com.zilen.weather.service.MainMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherConsoleApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherConsoleApplication.class);

    private final MainMenu mainMenu;

    public WeatherConsoleApplication(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(WeatherConsoleApplication.class, args).close();
        LOG.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args){
        LOG.info("EXECUTING : command line runner");
        mainMenu.createMenu();
    }
}
