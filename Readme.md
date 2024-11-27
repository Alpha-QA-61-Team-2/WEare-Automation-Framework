# **Project Documentation**

## **1. Prerequisites for Running the Tests**

This section lists all the necessary tools, configurations, and setup steps required to run the tests successfully.

### **1.1. Tools Required**
- **Java JDK**
- **Maven**
- **Selenium WebDriver**  
- **Rest Assured**  
- **Postman**
- **JUnit**
- **Testmo CLI**
- **Web Browser** (e.g., Chrome, Firefox, or Edge)
- **Browser Driver**

### **1.2. Project Setup and running of the tests:

you have to have the file: Auto_script.bat; save it in empty folder;
you have to have maven added to your PATH in system variables;

run the script, using the command prompt. After execution of script you can see the
test results on the https://alpha-61.testmo.net/automation/runs/1

## **3. Project Structure**

### **3.1. Folder Overview**
- **`src/main/java`**: Core framework, pages, and API services:
  - **`com.weare.api`**: Contains API services and data structures.
  - **`com.weare.pages`**: Implements Page Object Model for web pages.
  - **`com.weare.testframework`**: Core framework utilities (e.g., WebDriver management, base classes).  

- **`src/test/java`**: Contains test cases:
  - **`api/tests`**: API test cases (e.g., `PostTests.java`).
  - **`web`**: Web UI test cases (e.g., `CreatePostAndCommentTest.java`).  

- **`src/resources`**: Configuration files and test data (e.g., JSON files for API payloads).  

---

## **4. Key Concepts**

### **4.1. Page Object Model (POM)**
- Web tests leverage the **Page Object Model** for better maintainability.  
- Each page in the application corresponds to a Java class in the `com.weare.pages` package.  
- Examples:  
  - **`LoginPage.java`**: Handles login functionality.  
  - **`PostCreationEditPage.java`**: Handles creating and editing posts.

### **4.2. Test Framework**

s- **Base Classes:**
  - `BaseWebTest` and `BaseApiTest` provide reusable setup and teardown methods.
- **Driver Management:**  
  - `DriverManager.java` initializes and manages WebDriver instances.  

---

## **5. Logging and Reporting**
- **Logging:** The project uses `log4j` for logging. Configuration files are in `src/main/resources`.  
- **Reporting:** Test results are logged in the console and saved in the `target` folder after execution.  

---

## **6. Sample Test Data**
Test data is stored in JSON files under `src/test/resources/apitestdata`. Example:  
- `create-post.json`: Payload for creating a post via API.  
- `register-user.json`: Payload for user registration.
