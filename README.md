# Android Clean Architecture App

## Overview

This repository contains a sample Android application built using Clean Architecture principles. The app demonstrates best practices for structuring Android projects, ensuring scalability, maintainability, and testability. 

## Features

- **Modular Design:** The app is divided into layers (presentation, domain, and data) to separate concerns and promote code reusability.
- **Dependency Injection:** Utilizes Dagger/Hilt for managing dependencies, ensuring that classes are loosely coupled.
- **Testable:** Includes unit tests and UI tests to validate functionality and ensure reliability.
- **MVVM Pattern:** Implements the Model-View-ViewModel (MVVM) architecture for managing UI-related data in a lifecycle-conscious way.
- **Coroutines:** Utilizes Kotlin Coroutines for asynchronous programming, making it easier to handle background tasks and improve responsiveness.

## Project Structure

- **Presentation Layer:** Contains UI components (Activities, Fragments, ViewModels) responsible for displaying data and handling user interactions.
- **Domain Layer:** Holds business logic, use cases, and entities that define core application functionalities.
- **Data Layer:** Manages data sources, including remote APIs and local databases, and handles data mapping to domain entities.

## Getting Started

1. Clone the repository:
  git clone git@github.com:AleksSoftwareDev/ArchitectureClean.git

2. Open the project in Android Studio.

3. Sync Gradle and run the application on an emulator or physical device.

## Technologies Used

- Kotlin
- Android Jetpack components (ViewModel, LiveData, Room)
- Dagger/Hilt for dependency injection
- Retrofit for network calls
- Coroutines for asynchronous programming
- Unit testing with JUnit and Mockito

## Contribution

Contributions are welcome! Please feel free to submit a pull request or open an issue for discussion.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
