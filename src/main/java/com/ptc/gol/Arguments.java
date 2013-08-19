package com.ptc.gol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: Shantanu
 */
public class Arguments {

    private String EQUALS = "=";
    private Map<String, String> argMap = new HashMap<String, String>();

    public Arguments() {
        argMap.put("sleep", "600");
        argMap.put("iter", "-1");
    }

    public Arguments(String[] args, List<String> argErrors) {
        this();
        for (String arg : args) {
            if (!arg.startsWith("--")) {
                continue;
            }
            arg = arg.substring(2);
            String key = arg.split(EQUALS)[0];
            String value = arg.split(EQUALS)[1];
            try {
                argMap.put(key, value);
            } catch (Exception e) {
                argErrors.add("Argument is incorrectly formatted (example: \"--file=input.txt\").");
            }
        }
    }

    public int iterations() {
        return intValOf("iter");
    }

    public int sleep() {
        return intValOf("sleep");
    }

    public String file() {
        return argMap.get("file");
    }

    private int intValOf(String val) {
        return Integer.parseInt(argMap.get(val));
    }
}
