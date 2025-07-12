<center>

[![Language](https://img.shields.io/badge/Language-Java%2021+-red?logo=OpenJDK&logoColor=white)](https://openjdk.org/) [![Platform](https://img.shields.io/badge/Platform-Android%20%7C%20Spring%20Boot-blue?logo=android&logoColor=white)](https://developer.android.com/)  
[![Build Tool](https://img.shields.io/badge/Build%20Tool-Gradle-02303A?logo=gradle)](https://gradle.org/)  
[![Database Service](https://img.shields.io/badge/Database%20Service-Supabase-3ECF8E?logo=supabase&logoColor=white)](https://supabase.com/) [![Database System](https://img.shields.io/badge/Database%20System-PostgreSQL-316192?logo=postgresql&logoColor=white)](https://www.postgresql.org/)  
[![License](https://img.shields.io/badge/License-MIT-yellow)](./LICENSE)

</center>

# 🏟️ SportNexus

SportNexus is an online platform that helps people book courts for four major sports: **football, badminton, tennis, and pickleball**. With SportNexus, users can easily discover nearby courts, check real-time availability, and make instant bookings—all in one seamless and convenient experience.

By bridging the gap between players and venues across multiple platforms, SportNexus aims to create a smarter, more connected ecosystem for sports and recreation—so everyone can spend less time planning and more time playing.

---

## 📦 Key Features

- 👤 **User Accounts & Recovery**
  - Secure sign-up with optional phone and ID verification
  - Account recovery via verified contact or limited phone guessing
- 🏟️ **Court Booking**
  - Real-time availability, multi-slot booking, cancellation, and refunds
  - Owner-controlled pricing, blackout dates, and booking management
- 🔍 **Court Discovery**
  - Smart suggestions based on location, time, and user history
  - Filters and keyword-based search with prioritized matches
- 🏷️ **Court Profiles & Reviews**
  - Mini/full profiles with images, prices, services, and user reviews
  - AI-generated summaries highlighting common feedback and ratings
- 💳 **Payments**
  - Platform-mediated transactions, vouchers, and refund handling
  - Encouraged online payments for transparency
- ⭐ **Personalization**
  - Favorite courts, booking/review history, and UI customization
- 🏆 **Community Features**
  - Tournaments: Verified hosts, prize pools, and structured matches
  - Lobbies: Room booking with participant sharing and rules
  - Social Feed: Share updates, tag bookings or tournaments
- 🏅 **Reputation Point System**
  - Points-based system rewarding activity and penalizing misconduct
  - Affects access to features like lobby participation
- 🏢 **Court Owner Tools**
  - Court publishing, schedule control, and income statistics
  - Violation handling and user report resolutions

---

## 📱 Platform & Target Users

- **Platform:** Mobile (Android)
- **Backend:** Spring Boot (JavaDK 21), PostgreSQL (Supabase)
- **Target Users:** Sports players, Court owners
- **Purpose:** Enable users to reserve available sports courts directly from facility owners

---

## 📁 Project Structure (TODO: UPDATE THIS LATER)

```bash
/
├── src/
│   ├── backend/                # Spring Boot backend
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/       # Controllers, services, models, repositories
│   │   │   │   └── resources/  # application.properties, static files
│   │   │   └── test/           # JUnit tests
│   │   └── build.gradle        # Backend Gradle config
│   └── android/                # Android client app
│       ├── app/
│       │   ├── src/
│       │   │   ├── main/
│       │   │   │   ├── java/   # UI, ViewModels, UseCases, Entities, Retrofit
│       │   │   │   └── res/    # Layouts, resources
│       │   └── build.gradle    # Android Gradle config
│       └── ...
│
├── docs/                       # Documentation (architecture, requirements, etc.)
├── README.md                   # Project documentation
├── LICENSE                     # Project license
└── .gitignore                  # Git ignore rules
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- **JavaDK 21** (OpenJDK recommended)
- **Gradle** (for building both backend and Android)
- **Android Studio** (latest stable version)
- **Android SDK** (API level 33+)
- **Supabase PostgreSQL** instance (for backend database)
- **Internet connection** (for dependency and API access)

### ⚙️ Backend: Build and Run

```bash
# Build the backend 
./src/backend/gradlew clean build

# Boot the backend
./src/backend/gradlew bootRun
```

### 📱 Android: Build and Run

1. Open `src/android` in Android Studio.
2. Sync Gradle and download dependencies.
3. Configure the backend API base URL if needed.
4. Connect a device or start an emulator.
5. Build and run the app from Android Studio.

---

## 🧪 Running Backend Tests

```bash
./src/backend/gradlew test
```

---

## 📖 Documentation

- [Architecture](./docs/analysis%20and%20design/)
  + [Backend](./docs/analysis%20and%20design/backendArchitecture.md)
  + [Android](./docs/analysis%20and%20design/androidArchitecture.md)
- [Requirements](./docs/requirements/requirement.md)
- [Workflow Guide](./docs/management/workflow.md)

---

## 👨‍💻 Authors

- **Team Name:** HOANGTUCODE
- **Members:**  
  - Huynh Dang Khoa - 23127390  
  - Nguyen Van Bao Phuc - 23127457
  - Cao Le Gia Phu - 23127535 
  - Nguyen Thanh Nhan - 23127533

---

## 🏆 Contribution

| Member              | Contribution |
| ------------------- | ------------ |
| Huynh Dang Khoa     | **10**       |
| Nguyen Van Bao Phuc | **10**       |
| Cao Le Gia Phu      | **10**       |
| Nguyen Thanh Nhan   | **10**       |

---

## 📄 License

This project is licensed under the MIT License. See [`LICENSE`](./LICENSE) for full details.

---

_SportNexus: Redefining how you play, book, and connect through sports!_