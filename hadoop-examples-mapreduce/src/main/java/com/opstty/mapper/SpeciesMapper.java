package com.opstty.mapper;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class SpeciesMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        if (!value.toString().contains("ESPECE"))//header
        {
            Text species = new Text(value.toString().split(";")[3]);
            context.write(species, NullWritable.get());

        }
    }

}
