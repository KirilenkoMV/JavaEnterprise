MKDIR C:\Kirilenko
cd C:\Kirilenko
git clone https://github.com/KirilenkoMV/JavaEnterprise.git
cd C:\Kirilenko\JavaEnterprise\kirilenko-dao
mvn clean package
cd C:\Kirilenko\JavaEnterprise\kirilenko-dao\target
java -jar kirilenko-dao-1.0.1.jar
pause
