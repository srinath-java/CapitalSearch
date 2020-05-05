# CapitalSearch
This project using third party rest api's to lookup the capital city using input name or code and also some unit test written for those positivie and neagtive test cases .

## prerequisites
- git
- maven
- java
## Steps to run this project locally
- git clone https://github.com/srinath-java/CapitalSearch.git
- cd CapitalSearch
- mvn clean compile test
- mvn exec:java -Dexec.mainClass="services.CapitalService" 

above last cmd will allow you to enter code or name to search the capital city
