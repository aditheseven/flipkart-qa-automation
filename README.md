# flipkart-qa-automation
End-to-end QA automation test for Flipkart using Selenium WebDriver, Java, and TestNG. Includes product search, brand and rating filters, price sorting, and offer validation.

# Flipkart Selenium Automation Assignment

## Overview

This project automates product testing on Flipkart using **Java, Selenium WebDriver, and TestNG**.
The automation validates two scenarios related to product availability and cart functionality.

---

# Scenario 1: Product is Available

### Conditions

If the **Add to Cart button is visible and enabled**, the automation performs the following actions.

### Steps

1. Open Flipkart website.
2. Close login popup if present.
3. Search for **Bluetooth Speakers**.
4. Apply filters:

   * Brand → **boAt**
   * Customer Rating → **4★ & above**
5. Sort results by **Price – Low to High**.
6. Open the **first product** from the search results.
7. Scroll to the **Available Offers** section.
8. Count and print the number of offers.
9. Click **Add to Cart**.
10. Click **Go to Cart**.
11. Verify that the **Place Order** button is visible.
12. Capture a screenshot of the cart page.

### Output

Screenshot saved as:

```id="prh9uj"
screenshot.png
```

---

# Scenario 2: Product is NOT Available

### Conditions

If any of the following occur:

* **Add to Cart button is missing**
* **Add to Cart button is disabled**
* **Out of Stock message is displayed**

### Expected Behavior

The automation will:

* **NOT click any button**
* Print the message:

```id="u23jup"
Product unavailable — could not be added to cart.
```

* Capture a screenshot of the product page.

### Output

Screenshot saved as:

```id="g49gsi"
result.png
```

---

# Automation Flow

1. Launch Flipkart in Chrome.
2. Handle login popup if present.
3. Search for **Bluetooth Speakers**.
4. Apply filters:

   * Brand → **boAt**
   * Rating → **4★ & above**
5. Sort products by **Price – Low to High**.
6. Open the **first product** in a new tab.
7. Scroll to offers section.
8. Check product availability.
9. Execute **Scenario 1 or Scenario 2** based on conditions.
10. Capture screenshot accordingly.

---

# Tech Stack

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **ChromeDriver**
* **Eclipse / IntelliJ**

---

# Project Structure

```id="ruyb4s"
FlipkartAutomation
│
├── src
│   ├── base
│   │   └── TestBase.java
│   │
│   └── test_cases
│       ├── tc01.java   (Scenario 1)
│       └── tc02.java   (Scenario 2)
│
├── screenshot.png
├── result.png
├── pom.xml
└── README.md
```

---

# How to Run the Project

1. Clone the repository:

```id="5w71ku"
git clone https://github.com/your-username/FlipkartAutomation.git
```

2. Open the project in **Eclipse or IntelliJ**.

3. Install dependencies if using Maven.

4. Run TestNG test cases:

* **tc01.java** → Scenario 1
* **tc02.java** → Scenario 2

---

# Sample Console Output

Scenario 1:

```id="4hgm8l"
Number of offers: 5
Cart URL: https://www.flipkart.com/viewcart
Screenshot captured
```

Scenario 2:

```id="ci3lsr"
Product unavailable — could not be added to cart.
Screenshot saved as result.png
```

---

# Author

**Vijay Adithya**

Automation Testing Assignment
