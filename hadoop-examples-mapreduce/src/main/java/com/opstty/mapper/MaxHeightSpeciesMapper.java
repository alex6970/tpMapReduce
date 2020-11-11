package com.opstty.mapper;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MaxHeightSpeciesMapper extends Mapper<Object/*input key*/, Text/*input value*/, Text/*output key*/, DoubleWritable/*output value*/> {

    private final static DoubleWritable height = new DoubleWritable();
    private final static Text species = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        if (!value.toString().contains("ESPECE") || !value.toString().contains("HAUTEUR") )//header
        {

            String[] line = value.toString().split(";");

            if (line[6].isEmpty() || line[6] == null) {
                species.set(line[3]);
                context.write(species, new DoubleWritable((0.0)));
            } else {
                species.set(line[3]);
                height.set(Double.parseDouble(line[6]));
                context.write(species, height);

            }
        }
    }


}
