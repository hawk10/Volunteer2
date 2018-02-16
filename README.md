# Volunteer2
Project to record various methods,functions,libraries,etc
The project uses Spring with JPA + Hibernate

**AWS Creds are retreived from local host, the path can be found in the class AwsConfig 
**If Cognito Pool has already been created, the Aws Config class contains bean to build the connection to AWS Cognito for later retreival of Cognito Pool Id, Client Id, etc.
**AWS Config class contains the method the to retrive to Pool and Client ID from AWS to avoid unnecessary hardcoding or retreival of info from local host apart from the AWS Credentials


Topics of Interest
1) Implemented get User with param, that will take in String,Int,or Date value and will return  List of result.
In the Api call, the param,value,and type will be passed from that Criteria Builder is used to create query and return results

2)Create user in Cognito 

3)Login Function validated through Cognito

4)Interceptor validates api calls and validates aws token 
