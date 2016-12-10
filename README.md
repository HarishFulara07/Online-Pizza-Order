# Online Pizza Order Web Application

A basic web application built using Java Servlets to handle online orders of a restaurant that sells pizza. The web app handles the customer end and the restaurant manager end. I have made separate servlets handling the two categories of user profiles as described below.

## Customer View:

Customers can create a new order or track their placed order.

So the first page provides the user with these two options. 

**Option 1: Create new order**

On creating a new order the system generates an order id which the user will use to track the placed order in future. Once the id is generated and displayed to the user, he/she is displayed a menu - a short one containing about 4 varieties of pizzas with 3 sizes available. On clicking submit, the webpage navigates to another form asking the user to enter his name, contact number and address as mandatory fields. I have maintained the session (order id and selected items) while the previous page navigates to this page. On entering the personal details the user is navigated to the tracking page of his/her order indicating the progress till the order is delievered.

States possible(transition possible in the same order): **Order Placed**, **Preparation**, **Bake**, **Quality Check**, **Out for delivery**, **Delivered**.

**Option2: Track my order**

Customer is prompted to enter the order id. On submitting it, the progress of the order (Order Placed, Preparation, Bake, Quality Check, Out for delivery, Delivered) is displayed.

## Restaurant Manager View:

The manager is able to view all the pending(undelivered) orders and their state in tabular form, with an update button corresponding to each row. On clicking the update, the stage of that order gets incremented to the next stage.
