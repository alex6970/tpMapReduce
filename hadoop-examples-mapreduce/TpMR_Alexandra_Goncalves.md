# MapReduce2 JAVA Lab

### 1.6.3 Run the job
Start the **wordcount** job using the JAR that we send to the edge node. Referer
to previous labs for the command.

> -sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar wordcount inputJar outputJar/
>> 20/10/30 18:30:15 INFO client.AHSProxy: Connecting to Application History server at hadoop              -master03.efrei.online/163.172.100.24:10200  
20/10/30 18:30:15 INFO hdfs.DFSClient: Created token for agoncalves  
[...]
20/10/30 18:31:48 INFO mapreduce.Job:  map 100% reduce 0%  
20/10/30 18:31:53 INFO mapreduce.Job:  map 100% reduce 100%    
20/10/30 18:31:54 INFO mapreduce.Job: Job job_1603290159664_1027 completed successfully
[...]

We check what's in the output file outputTest/part-r-00000 :

>-sh-4.2$ hdfs dfs -cat outputTest/part-r-00000
>>du      1  
jar     1  
test    1  
tp1     1  

# 1.8 Remarkable trees of Paris
### 1.8.1 Districts containing trees

We must write a mapreduce program in Java that displays the list of distinct containing trees in the Paris Dataset

First we add map, reducer and job classes to the project in which we implement the MapReducer code. Then, we compile with Maven package.

With Filezilla, we import in the hdfs home the new .jar file and the dataset (trees.csv).

>-sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar districts trees.csv outputDistricts/
>> 20/11/03 10:54:43 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200  
20/11/03 10:54:43 INFO hdfs.DFSClient: Created token for agoncalves: HDFS_DELEGATION_TOKEN owner=agoncalves@EFREI.ONLINE   
[...]   
20/11/03 10:55:08 INFO mapreduce.Job:  map 100% reduce 100%  
20/11/03 10:55:09 INFO mapreduce.Job: Job job_1603290159664_1339 completed successfully  
[...]

If we check the output :
>-sh-4.2$ hdfs dfs -cat outputDistricts/part-r-00000  
>> 11  
12  
13  
14  
15  
16  
17  
18  
19  
20  
3  <br>
4  <br>
5  <br>
6  <br>
7  <br>
8  <br>
9  

### 1.8.2 Show all existing species

Here, we should write a MapReduce job in order to display the list of different species trees in the file. As we did previously :

> -sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar species trees.csv outputSpecies/

Output :

> -sh-4.2$ hdfs dfs -cat outputSpecies/part-r-00000
>> araucana  
atlantica  
australis  
[...]  
tulipifera  
ulmoides  
virginiana  
x acerifolia  


### 1.8.3 Number of trees by species

We are asked to write a MapReduce job that calculates the number of trees of each species

> -sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar numbertrees trees.csv outputNumbertrees/

Output :
> -sh-4.2$ hdfs dfs -cat outputNumbertrees/part-r-00000
>> araucana	1  
atlantica	2  
australis	1  
baccata	2  
bignonioides	1  
biloba	5  
[...]  
tulipifera	2  
ulmoides	1  
virginiana	2  
x acerifolia	11  

### 1.8.4 Maximum height per specie of tree

We must write a MapReduce job that calculates the height of the tallest tree of each
kind.

> -sh-4.2$ yarn jar hadoop-examples-mapreduce-1.0-SNAPSHOT-jar-with-dependencies.jar maxheightspecies trees.csv outputMaxHeight/

Output :

> -sh-4.2$ hdfs dfs -cat outputMaxHeight/part-r-00000
>> araucana	9.0  
atlantica	31.0  
australis	16.0  
baccata	13.0  
bignonioides	15.0  
[...]  
tulipifera	57.0  
ulmoides	12.0  
virginiana	26.0  
x acerifolia	75.0   


###
