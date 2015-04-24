# uTestProblem
This is response for uTest's test problem for automated testers.

# NOTE
I have tested this app only on windows platform. I am not sure if this example will run well on Unix or Mac platforms.

# Prerequisites
1. Install latest version of JDK. (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Install latest version of Maven (https://maven.apache.org/download.cgi)
3. Add JAVA_HOME to the variables (it should point to JDK installation folder %path%/Java/jdk%version%)
4. Add Maven to the Path, so you are able to run mvn command from console (https://maven.apache.org/guides/getting-started/windows-prerequisites.html)

If you are able to run mvn command in command line then you are all set. Example of execution is below:
> mvn -version
> Apache Maven 3.3.1 (cab6659f9874fa96462afef40fcf6bc033d58c1c; 2015-03-13T16:10:2
> 7-04:00)
> Maven home: C:\apache-maven\bin\..
> Java version: 1.8.0_45, vendor: Oracle Corporation
> Java home: C:\Program Files\Java\jre1.8.0_45
> Default locale: en_US, platform encoding: Cp1252
> OS name: "windows 8.1", version: "6.3", arch: "amd64", family: "dos"


# How To Run
In order to run script, please execute "run.bat" batch file. It is located in root directory of the project. The CMD window is closed after execution, even if there is pause at the end. Seems like the mvn does something at the end, not sure why. Anyway, you can see results in the generated log file. Logs are colected in 'Logs' folder of root project folder. If you would like to see results in console then you have to run 'run.bat' batch file from CMD window.

# Framework Configuration
There is configuration file (Config.xml) in 'src/resources'. At this file you can configure Browser type, default url, and some timeouts.

# Test case configuration
There is testng.xml configuration at the root folder of the project. From this file you can add different parameters for written scenario. This file contains examples, so you can add your parameters very easy.
