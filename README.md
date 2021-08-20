# barber-shop-core

High Level Design:
The barber shop project is basically implementation of producer consumer which leverage the BlockingQueue datastructure in java. It's basically an console application. 
At the very start of execution, application asks for number of chairs in barber shop which is basically meant to define the size of blocking queue which represents number of customers it the shop can accomodate.
Next the application ask for the options to continue with customer addition or exiting the application
When you select to continue with addition then application asks for customer name and service. There are 3 services which corresponds to the ammount of time 
barber will take for the particular customer till the customer vacate the chair making it available. There are 3 services:
1. Hair Style - 30 seconds
2. Shaving - 15 seconds
3. Face massage - 60 seconds
Once the service is completed for a customer the chair becomes available for another customer. If all the chairs are full application will deny customer with sorry message
If all the chairs and there is no customer then barber will wait for new customer and as once new customer is rgistered barber will start again with the work

Low Level design:
Basically the application uses BlockingQueue as chairs which holds the Customer entity which includes customer name and service for customer. A thread gets created for barberTask which basically consumes the customer in chairs one by one and go for sleep which is determined by the customer entity
                         
                              Customer1 | Customer2 | ........... |CustomerN-1     
      Main thread(producer) -----------------------------------------------------> barberTask thread(consumer)
                                                  Chairs(Blocking queue)
                                    
Execution Instructions:
1. Set the JAVA_HOME variable with home directory of java jdk
2. Open cmd and got application home directory perform maven build by doing "maven clean install"
3. Go to target folder and run the application using command "java -jar barbershop.jar"
