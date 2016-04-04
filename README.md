# spark-spray
Spark CDH 5.4 (1.3) based restful Spray application

It a simple application for integration of Spark and Spray. Please note that we are using Spray 1.2.1 because the Akka version matches between
Spark CDH and Spray.(Akka 2.2.3). With Spray 1.3 was facing few Akka issue.

Can be run using below command in CDH--

spark-submit --master yarn-client --class demo.StartSpark /home/cloudera/akka-1.0-SNAPSHOT.jar
