
### WEare Tests
- `WEareBaseWebTest.java`: Base class for WEare application web tests.
- `SearchTermTests.java`: Contains tests for Google search functionality.

#### API Tests
- `WEareApiTests.java`: API tests for the WEare application.

#### Core
- `WEareApiTests.java`: Base class for WEare application API tests.
- `WEareBaseWebTest.java`: Base class for WEare application web tests.

#### Enums
- `TestData.java`: Contains enumerated test data for WEare application tests.

#### Web Tests
- `LoginTests.java`: Tests for the login functionality of WEare.

#### Resources
- `config.properties`: Configuration file for test execution settings.

## Usage

This test structure demonstrates a well-organized approach to testing multiple applications:

1. **WEare Tests**: A comprehensive test suite for the WEare application, including:
   - API testing
   - Web UI testing
   - Separate base classes for API and Web tests
   - Enumerated test data
   - Configuration properties

Developers can add new test classes to the respective packages and extend the base classes as needed. The structure allows for easy maintenance and scalability of the test suite.