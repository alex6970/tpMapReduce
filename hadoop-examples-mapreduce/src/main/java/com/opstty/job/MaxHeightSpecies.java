package com.opstty.job;

import com.opstty.mapper.MaxHeightSpeciesMapper;
import com.opstty.mapper.NumberTreesMapper;
import com.opstty.reducer.MaxHeightSpeciesReducer;
import com.opstty.reducer.NumberTreesReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MaxHeightSpecies {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
        if (otherArgs.length < 2) {
            System.err.println("Usage: maxheightspecies <in> [<in>...] <out>");
            System.exit(2);
        }
        Job job = Job.getInstance(conf, "maxheightspecies");
        job.setJarByClass(MaxHeightSpecies.class);
        job.setMapperClass(MaxHeightSpeciesMapper.class);
        job.setCombinerClass(MaxHeightSpeciesReducer.class);
        job.setReducerClass(MaxHeightSpeciesReducer.class);
        job.setOutputKeyClass(Text.class); //Type key
        job.setOutputValueClass(DoubleWritable.class); //type value
        for (int i = 0; i < otherArgs.length - 1; ++i) {
            FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
        }
        FileOutputFormat.setOutputPath(job,
                new Path(otherArgs[otherArgs.length - 1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
