# Java - IDE - Git - Maven :: introductory exercises 

**Task 1 - Java**
- Install one of the newest Java (JDK 17): [jdk-link](https://www.oracle.com/java/technologies/downloads/#java17)
- Set environment variable: *JAVA_HOME* in your operating system
- Using command line or terminal, type: *java -version*
- ![](https://github.com/zzpj/pl-java2022/blob/main/intro/java_config_17.jpg "jdk17 windows")
- ![](https://github.com/zzpj/pl-java2022/blob/main/intro/java_config_14_unix.jpg "jdk14 ubuntu")
- Manage SDK (including JDK) like a pro - using https://sdkman.io/

**Task 2 - Git**
- Github account creation: [sign up](https://github.com/)
- Git familiarization: [learn git branching](https://learngitbranching.js.org/)
- Enable Travis CI on Your project
- Configure Dependabot
- Interesting GIT aliases - https://github.com/jakubnabrdalik/gitkurwa

**Task 3 - IDE**
- If you do not have Integrated Development Environment (IDE), it is a perfect time to install!
- **Recommendation:** IntelliJ
- Other: Eclipse or Netbeans

**Task 4 - Maven I (+ Lombok)**
- Familiarize with some theory - [short presentation](https://github.com/zzpj/pl-java2022/blob/main/intro/ZZPJ2021-maven.pdf)
- [Download maven package](https://maven.apache.org/download.cgi?Preferred=http%3A%2F%2Fapache.mirrors.tworzy.net%2F#)
- Set environment variable: `MAVEN_HOME`
- Using command line or terminal, check your maven version: `mvn -v` or `mvn --version`
- Generate project with the archetype „quickstart” (default): `mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4`
- Import project into IDE
- Optional way: you can create maven project structure using your IDE
- Review `pom.xml`
- Build package using Maven (using command line): `mvn clean install`
- Add project's lombok dependency 
    ```
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.22</version>
      <scope>provided</scope>
    </dependency>
    ```
- Create simple Java class with lombok annotation
- Build again using Maven

**Task 5 - Maven II**
- Create two independent projects
- First provides model-api (use lombok lib)
- Second uses provided api (create model class instances and prints them on console)
- Provide several release versions with updated api
- Localize where model the jars have been deployed
 
**Task 6 - Maven III**
- Create two separate profiles and three properties files 
- First `dev` profile is for developing purposes and reads `config.dev.properties` file 
- Second `prod` profile is for release purpose and reads `config.prod.properties` file
- Third properties file should be named: `config.properties`
    - All useful code snippets could be found [here](https://github.com/zzpj/pl-java2022/blob/main/intro/maven-helpful-snippets.md) 




