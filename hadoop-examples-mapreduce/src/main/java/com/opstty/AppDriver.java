package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");

            programDriver.addClass("districts", Districts.class,
                    "A map/reduce program that counts the districts.");

            programDriver.addClass("species", Species.class,
                    "A map/reduce program that displays the list of different species trees in this\n" +
                            "file.");

            programDriver.addClass("numbertrees", NumberTrees.class,
                    "A map/reduce program that calculates the number of trees of each species.");

            programDriver.addClass("maxheightspecies", MaxHeightSpecies.class,
                    "A map/reduce program that calculates the height of the tallest tree of each\n" +
                            "kind.");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}











