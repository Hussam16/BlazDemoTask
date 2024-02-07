 ### Project Name: DemoBlaze Automation Tests

---

### Overview:
This project contains automated tests for the DemoBlaze website using Selenium WebDriver and TestNG. The tests cover various functionalities such as user registration, login, navigation through categories, adding products to the cart, deleting products from the cart, and placing orders.

---

### Prerequisites:
- JDK installed
- Maven installed
- WebDriver binaries for the desired browser (Chrome, Firefox, etc.)

---

### Setup Instructions:
1. Clone the repository to your local machine.
2. Import the project into your preferred IDE.
3. Ensure all dependencies specified in the pom.xml file are resolved.
4. Download the appropriate WebDriver binaries and update the DriverFactory class accordingly.
5. Run the tests using TestNG.

---

### Test Cases:

1. **SignUpBlazeDemo:**
   - Test user registration functionality.
   - Verifies successful sign-up message.

2. **LoginBlazeDemo:**
   - Test user login functionality.
   - Verifies successful login and the presence of the logout button.

3. **categoriesHasItems:**
   - Test whether categories have items.
   - Verifies that each category (Monitors, Laptops, Phones) has at least one item.

4. **addRandomItemToCart:**
   - Test adding a random laptop to the cart.
   - Verifies successful addition of the product to the cart.

5. **deleteRandomProduct:**
   - Test deleting a random product from the cart.
   - Verifies successful deletion of the product from the cart.

6. **placeorder:**
   - Test placing an order.
   - Verifies successful placement of the order.

---

### Note:
- Make sure to update the WebDriver paths and configurations as per your local setup.
- Adjust any necessary waits or timeouts based on your environment and website responsiveness.
- Feel free to expand and enhance the tests as per your requirements.
