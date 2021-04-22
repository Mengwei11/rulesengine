# rulesengine
A rule engine to check business rules

# Design Ideas

The main idea of this design based on Factory pattern, which enables the consumer don't need to care how is handled. They only need to provide the purchured products. 

Originally, i was thinking payment could be the domain, and the business rules apply on different payment type. However, it becomes completed when managing the operations.
The second refactoring convert the payment from abstract class to an interface, which each payment will be implemented. The payment is based on the product.Different product can 
use same payment service. 

The input of this service is Product(name, productType), the output is printing out the different steps for different product. 

# Package structure
The package structure is modified based on common used Onion architecture: product as the domain model, and all the operations(fx. packing, membership management) support the business domain. 

# How to extend
The design aims to be easy extend and modified. If fx. requirement for the physical product changes, we only need to either modify the PhysicalPaymentService or implement a new version of this PhysicalPaymentService. It is also easy to extend with other type of prodcuts. The things you need to do>
1. Add Product type into ProductType class
2. Add a new paymentService to implements the PaymentService interface
3. Add new services if other operation is needed. 

# How to run
Due to the time limit, I didn't implemet a RESTful endpoint to trigger the application. If you would like to check the engine.
1. Clone the repository to your local and import it using your favoriate IDE
2. Find "RulesEngineApplication" class, click 'Run application'(green) button. Like the following pic
<img width="779" alt="Screenshot 2021-04-22 at 19 07 21" src="https://user-images.githubusercontent.com/17132725/115755807-0771f080-a39e-11eb-8965-2859c9ddffe9.png">
3. If you would like to try out different product, just change the initilization of the Product object inside main method. 

Thanks for reading. :)
