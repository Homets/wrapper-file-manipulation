# wrapper-file-manipulation

## Installation
### Prerequisite
#### Maven
#### JDK 20 JAVA_HOME environnement variable (you can change version required for install in pom.xml)
```
$ git clone git@github.com:Homets/wrapper-file-manipulation.git
$ cd file-wrapper-mainipulation
$ mvn package -e -Dmaven.test.skip=true
```
## Functions
#### .write(String filename, char[]|String|Integer)
```java
FileUtils.write(String fileame,char[] charbuf);
FileUtils.write(String fileame, String stringToAppend);
FileUtils.write(String filename, Integer integerToAppend);
```
#### .append(String filename, char[]|String|Integer)
```java
FileUtils.append(String fileame,char[] charbuf);
FileUtils.append(String fileame, String stringToAppend);
FileUtils.append(String filename, Integer integerToAppend);
```
####.clean(String filename);
```java
  FileUtils.clean(String filename);
```
