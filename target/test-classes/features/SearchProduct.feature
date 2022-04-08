Feature: Search and place the order for products

#Scenario: Search experience for product search in both home and offers page
#Given User is on Green Cart Landing page
#When Usemr search for a product with short name "tom" and extract actual name
#Then User searched for same short name "tom" in offers page
#And Vaidate product name in offer page is same as in landing page

@Offerpage
Scenario Outline: Search experience for product search in both home and offers page
Given User is on GreenCart Landing page
When user searched with Shortname <productName> and extracted actual name of product
Then User searched for same short name <productName> in offers page
And Vaidate product name in offer page is same as in landing page
Examples:
|productName|
|tom|
|beet|