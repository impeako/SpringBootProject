package com.sesame.demo.commun;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import java.util.stream.Collectors;
import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public final class Outils {
    private Outils() {
    }

    public static void silence() {
        Logger racine = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        racine.setLevel(Level.WARN);
    }

    public static String beans(ApplicationContext ctx) {
        return Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(nom -> !nom.startsWith("org.springframework"))
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
