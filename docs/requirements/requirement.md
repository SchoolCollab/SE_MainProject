# SportNexus Project Requirements

This document lists the requirements to run both the **backend** and **Android** components of the SportNexus project.

***

## Backend Requirements

### Prerequisites

- **Java Development Kit (JDK) 21** 
- **Gradle** build tool  
- **Internet connection** (for dependency downloads and database access)

### Environment Variables / Configuration

- Database URL, username, and password (see `application.properties`)
- (Optional) Custom port or security settings
- Set

### How to Run

1. Navigate to the backend directory:
    ```sh
    cd src/backend
    ```
2. Build the project:
    ```sh
    ./gradlew clean build
    ```
3. Run the application:
    ```sh
    ./gradlew bootRun
    ```

***

## Android Requirements

### Prerequisites

- **Android Studio** (latest stable version recommended)
- **Android SDK** (API level 33 or higher recommended)
- **Java 21** or higher
- **Internet connection** (for dependency downloads and API access)

### How to Run

1. Open the Android project in Android Studio (`src/android` directory).
2. Sync Gradle and download dependencies.
3. Configure the backend API base URL in the app's configuration (if required).
4. Connect an Android device or start an emulator.
5. Build and run the application from Android Studio.

***

## Notes

- Ensure the backend server is running and accessible before launching the Android app.
- Update configuration files with the correct API endpoints and database credentials as needed.
- For development, you may need to allow network access to your backend server from your Android device/emulator.