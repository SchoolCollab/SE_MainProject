# SportNexus Android Project Architecture

The MVVM Clean Architecture is a software design pattern that combines the `Model-View-ViewModel` (MVVM) pattern with the principles of `Clean Architecture`. Its main goal is to create a **clear separation of concerns**, making the application easy to scale, test, and maintain.

This architecture organizes the project into three main layers that communicate with each other in a strict one-way dependency flow: **UI → Domain → Data**.

***

## Explanation of Main Components

Below are the meanings of each term in this architecture:

* **UI (User Interface)** 📱  
    This is the application's interface that users interact with. In modern Android development, this layer is often built using **`Jetpack Compose`**. Its job is to display data provided by the `ViewModel` and capture user actions (such as button clicks or text input), then pass them to the `ViewModel`.

* **ViewModel**  
    A core component of the `MVVM` pattern. It acts as a **bridge** between the `UI` and the `Domain` layer. It holds the **UI state** (the data to be displayed) and provides that data for the `UI` to observe. The `ViewModel` calls **`Use Cases`** to execute business logic and updates the UI state with the results. It is designed to survive configuration changes, such as screen rotations.

* **DI (Dependency Injection)** 💉  
    This is a design pattern where an object's dependencies (other objects it needs to function) are "injected" from an external source, rather than the object creating them itself. This makes the code more modular and easier to test. **`Hilt`** is the library recommended by Google for `DI` in Android.

* **Domain (Business Logic Layer)** 🧠  
    This is the **core of your application**. This layer contains essential business logic and rules. Most importantly, the `Domain` layer is a pure `Kotlin/Java` module and **does not depend** on the Android framework. This makes it highly reusable and testable.
    * **`Use Case` (or Interactor):** A class in the `Domain` layer that represents a specific user action or task, such as ``RegisterUserUseCase`` or ``GetBookingsUseCase``. It coordinates the data flow by calling the Data layer.
    * **`Entity`:** A simple data class in the `Domain` layer representing a core business object (e.g., ``User``, ``Booking``). In the Android project, entities are used only as types for data transfer and UI display, not for implementing business logic or persistence. All business logic and data management are handled by the backend.

* **Data Layer** 💾  
    This layer is responsible for **providing the data** required by the `Domain` layer. In this project, the Data layer contains only the implementation for communicating with the backend.
    * **`Retrofit API Service`:**  
        The Data layer uses **Retrofit** to communicate with the backend server via REST APIs. Retrofit interfaces define HTTP endpoints, request/response models, and handle network operations. The Data layer sends and receives data using these Retrofit services, mapping responses to the entity types used in the Domain layer.

***

## Data Flow Overview

1. **UI** triggers an action (e.g., button click).
2. **ViewModel** receives the action and calls the appropriate **Use Case**.
3. **Use Case** interacts directly with the Data layer to perform business logic.
4. **Data layer** uses **Retrofit** to communicate with the backend.
5. **Backend** processes the request, performs all data management and business logic, and returns the result.
6. **ViewModel** updates the UI state based on the results.

***

## Summary Table

| Layer     | Main Responsibility                       | Technologies/Patterns                 |
| --------- | ----------------------------------------- | ------------------------------------- |
| UI        | Display data, handle user input           | Jetpack Compose, XML, Activities      |
| ViewModel | UI state, business logic bridge           | Android ViewModel, LiveData/StateFlow |
| DI        | Dependency management                     | Hilt                                  |
| Domain    | Use cases, entity types for data transfer | Kotlin/Java, Use Case classes         |
| Data      | Data access via backend (Retrofit)        | Retrofit                              |

***

_This architecture ensures a robust, testable, and scalable Android application that communicates efficiently with the backend using Retrofit. All business logic and data management are centralized in the backend, while the Android app focuses on presentation and user interaction._