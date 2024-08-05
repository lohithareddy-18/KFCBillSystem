# KFC Billing System

![KFC Logo]![image](https://github.com/user-attachments/assets/048cd416-604e-4c87-9576-943d386e3d12)


## Overview

This project simulates a simple KFC billing system in Java. The system includes the following features:
- A menu with prices
- Order placement with quantity specification
- Customer notification to wait
- Token number system for order tracking
- Multiple billing counters for processing orders

## Features

- **Menu with Prices**: Displays a menu with items and their prices.
- **Order Placement**: Allows customers to place orders by selecting menu items and specifying the quantity.
- **Customer Notification**: Informs customers to wait while their order is being processed.
- **Token Number System**: Assigns a unique token number to each order for tracking.
- **Billing Counters**: Three billing counters operate simultaneously to process orders.

## How It Works

1. **Menu Display**: The system displays a menu with four options: Chicken Bucket, Burger, Fries, and Exit.
2. **Order Placement**: The customer selects an item and specifies the quantity.
3. **Token Number Assignment**: Each order is assigned a unique token number.
4. **Customer Notification**: The customer is informed of their token number and asked to wait.
5. **Order Processing**: The order is added to a queue and processed by one of the three billing counters.
6. **Order Completion**: The system simulates the time taken to process an order and then notifies when the order is complete.

## Classes

### Customer

Represents a customer with a unique token number, order details, quantity, and total price.

### BillingCounter

Represents a billing counter that processes customer orders. Each counter runs on a separate thread.

### KFCBillingSystem

The main class that handles the menu display, order placement, and assignment of orders to billing counters.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java IDE or text editor

### Running the Program

1. Clone the repository or download the source code.
2. Open the project in your preferred Java IDE or text editor.
3. Compile the code:
    ```sh
    javac KFC.java
    ```
4. Run the compiled code:
    ```sh
    java KFC
    ```
5. Follow the prompts to place orders.

## Example

```sh
KFC Menu:
1. Chicken Bucket - $10.99
2. Burger - $5.99
3. Fries - $2.99
4. Exit
Place your order (1-4): 1
Enter the quantity: 2
Your token number is: 1
Please wait while your order is being processed.
