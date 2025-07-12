Of course. Here is the directory structure formatted for a `README.md` file, including a brief explanation of each layer.

-----

## 📁 Project Structure

This project follows the **MVVM (Model-View-ViewModel)** and **Clean Architecture** principles, with a focus on feature-based packaging.

```
src/Android/
└── app
    ├── build.gradle.kts
    ├── proguard-rules.pro
    └── src
        └── main
            ├── AndroidManifest.xml
            └── java
                └── com
                    └── hoangtucode
                        └── sportnexus
                            ├── MainActivity.kt
                            ├── SportNexusApp.kt
                            │
                            ├── common
                            │   ├── components
                            │   └── util
                            │
                            ├── data
                            │   ├── local
                            │   │   └── SportNexusDatabase.kt
                            │   ├── remote
                            │   │   ├── SportNexusApi.kt
                            │   │   └── dto
                            │   └── repository
                            │
                            ├── di
                            │   ├── AppModule.kt
                            │   ├── NetworkModule.kt
                            │   └── DatabaseModule.kt
                            │
                            ├── domain
                            │   ├── model
                            │   └── repository
                            │
                            └── presentation
                                ├── navigation
                                │   ├── AppNavigation.kt
                                │   └── Screen.kt
                                ├── theme
                                │   ├── Color.kt
                                │   ├── Theme.kt
                                │   └── Type.kt
                                │
                                └── features
                                    ├── auth
                                    │   ├── login
                                    │   ├── register
                                    │   └── verification
                                    │
                                    ├── court_booking
                                    │   ├── search
                                    │   ├── details
                                    │   └── booking
                                    │
                                    ├── social
                                    │   ├── swipe
                                    │   ├── lobby
                                    │   └── chat
                                    │
                                    ├── profile
                                    │   ├── view
                                    │   ├── edit
                                    │   └── history
                                    │
                                    ├── court_owner
                                    │   ├── dashboard
                                    │   ├── manage_courts
                                    │   └── manage_bookings
                                    │
                                    └── tournament
                                        ├── list
                                        └── bracket
```

-----

### Layer Explanation

  * **`common`**: Contains shared code, such as reusable UI components and utility functions, to avoid duplication across features.
  * **`data`**: Implements the logic for data retrieval and storage. It includes local database definitions (Room), remote API services (Retrofit/Ktor), and repository implementations.
  * **`di`**: Handles dependency injection using Hilt or Koin, providing necessary dependencies throughout the app.
  * **`domain`**: The core business layer. It contains pure Kotlin modules with business models, use cases, and repository interfaces, making it independent of the Android framework.
  * **`presentation`**: The UI layer, which includes:
      * **`navigation`**: Defines the app's navigation graph.
      * **`theme`**: Contains Jetpack Compose theming (colors, typography).
      * **`features`**: Contains all UI-related code (Screens and ViewModels), organized by application feature (e.g., authentication, booking, profile).
