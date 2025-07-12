src
└── Android
    ├── app
    │   ├── build.gradle.kts
    │   ├── proguard-rules.pro
    │   └── src
    │       └── main
    │           ├── AndroidManifest.xml
    │           └── java
    │               └── com
    │                   └── hoangtucode
    │                       └── sportnexus
    │                           ├── MainActivity.kt
    │                           ├── SportNexusApp.kt  // Main application class for Hilt setup
    │                           │
    │                           ├── common // Shared code across features
    │                           │   ├── components // Reusable UI components (e.g., CustomButton, LoadingIndicator)
    │                           │   └── util // Utility classes, constants, extensions
    │                           │
    │                           ├── data // Data layer implementation
    │                           │   ├── local // Room Database, DataStore
    │                           │   │   └── SportNexusDatabase.kt
    │                           │   ├── remote // Retrofit/Ktor API definitions
    │                           │   │   ├── SportNexusApi.kt
    │                           │   │   └── dto // Data Transfer Objects for API communication
    │                           │   └── repository // Repository implementations
    │                           │
    │                           ├── di // Dependency Injection (Hilt/Koin)
    │                           │   ├── AppModule.kt
    │                           │   ├── NetworkModule.kt
    │                           │   └── DatabaseModule.kt
    │                           │
    │                           ├── domain // Core business logic (use cases, models, repository interfaces)
    │                           │   ├── model // Core data models (e.g., User, Court, Booking)
    │                           │   └── repository // Repository interfaces
    │                           │
    │                           └── presentation // UI Layer (Screens, ViewModels, Navigation)
    │                               ├── navigation
    │                               │   ├── AppNavigation.kt
    │                               │   └── Screen.kt
    │                               ├── theme
    │                               │   ├── Color.kt
    │                               │   ├── Theme.kt
    │                               │   └── Type.kt
    │                               │
    │                               └── features // All app features are organized as modules here
    │                                   ├── auth // Authentication feature
    │                                   │   ├── login
    │                                   │   │   ├── LoginScreen.kt
    │                                   │   │   └── LoginViewModel.kt
    │                                   │   ├── register
    │                                   │   │   └── RegisterScreen.kt
    │                                   │   └── verification
    │                                   │       └── PhoneVerificationScreen.kt
    │                                   │
    │                                   ├── court_booking // Court search and booking
    │                                   │   ├── search
    │                                   │   │   ├── CourtSearchScreen.kt
    │                                   │   │   └── CourtSearchViewModel.kt
    │                                   │   ├── details
    │                                   │   │   ├── CourtDetailsScreen.kt
    │                                   │   │   └── CourtDetailsViewModel.kt
    │                                   │   └── booking
    │                                   │       ├── BookingScreen.kt
    │                                   │       └── BookingViewModel.kt
    │                                   │
    │                                   ├── social // Player matching, lobbies, chat
    │                                   │   ├── swipe
    │                                   │   │   ├── TeammateSwipeScreen.kt
    │                                   │   │   └── TeammateSwipeViewModel.kt
    │                                   │   ├── lobby
    │                                   │   │   ├── LobbyScreen.kt
    │                                   │   │   └── LobbyViewModel.kt
    │                                   │   └── chat
    │                                   │       ├── ChatListScreen.kt
    │                                   │       └── ConversationScreen.kt
    │                                   │
    │                                   ├── profile // User profile, settings, history
    │                                   │   ├── view
    │                                   │   │   ├── ProfileScreen.kt
    │                                   │   │   └── ProfileViewModel.kt
    │                                   │   ├── edit
    │                                   │   │   └── EditProfileScreen.kt
    │                                   │   └── history
    │                                   │       └── BookingHistoryScreen.kt
    │                                   │
    │                                   ├── court_owner // All screens for court owners
    │                                   │   ├── dashboard
    │                                   │   │   ├── OwnerDashboardScreen.kt
    │                                   │   │   └── OwnerDashboardViewModel.kt
    │                                   │   ├── manage_courts
    │                                   │   │   └── ManageCourtScreen.kt
    │                                   │   └── manage_bookings
    │                                   │       └── ManageBookingsScreen.kt
    │                                   │
    │                                   └── tournament // Tournament feature
    │                                       ├── list
    │                                       │   └── TournamentListScreen.kt
    │                                       └── bracket
    │                                           └── TournamentBracketScreen.kt
