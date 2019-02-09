#!/bin/bash
PATH_TO_JAVA=skeleton
PATH_TO_TEST_INPUT=input
PATH_TO_TEST_OUTPUT=output

#CS1020 Testcase script
echo "These test cases are provided for your convenience only"
echo "Passing these test cases does not imply full marks"
echo -e "++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"

pkill -U $(whoami) java

echo -n "Enter Java File Name > "
read fileName
echo -n "Testcase File Name > "
read testName
echo -e ""

echo "Testing" $fileName".java ..."

cp $PATH_TO_JAVA/$fileName.java $fileName.java
javac $fileName.java
if [ $? -ne 0 ] #check for compile!!
then
  echo -e "\t $fileName.java didn't COMPILE"
  exit 1
fi
echo -e "\t $fileName.java COMPLIED without ERROR"


for i in {1..8}
    do  
        cp $PATH_TO_TEST_INPUT/$testName$i.in $testName$i.tmp
        
        java $fileName < $testName$i.tmp > result$i
        
        diff -wi $PATH_TO_TEST_OUTPUT/$testName$i.out result$i 2> /dev/null
        if [ $? -ne 0 ]
        then
          echo -e "\t Failed test case $i"
          
        else
          echo -e "\t Passed test case $i"
        fi
        rm $testName$i.tmp
        rm result$i  
done
rm $fileName.java

echo -e ""
echo "Finished testing $fileName.java"
echo -e "++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
pkill -U $(whoami) java
rm *.class
