package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class NumberTreesMapper extends Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable one = new IntWritable(1);
    private final static Text numbertrees = new Text();

    public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

        if (!value.toString().contains("ESPECE"))//header
        {
            String[] line = value.toString().split(";");
            numbertrees.set(line[3]);
            context.write(numbertrees, one);

        }
    }
}

//MaxHeightSpecies