# App-Recipes

This Android application allows users to explore, save, and manage culinary recipes. It provides a simple and interactive interface to search for recipes, view their details, and save favorites.

## Key Features

- **Recipe Management**: Each recipe includes details such as:
  - Category
  - Description
  - Difficulty level
  - Preparation time
  - Ingredients
  - Required tools
  - Image

- **Custom Ingredients**: Ingredients are managed through unique identifiers, names, and categories.

- **User Profiles**: Users can:
  - Create accounts
  - Log in
  - Save their favorite recipes for quick access

### Interactive UI

- **Add Recipe**: A dedicated interface for users to contribute their own recipes.
- **Home Section**: Displays curated recipes and quick access to functionalities.
- **Notifications Section**: Keeps users updated with app-related alerts or updates.
- **Navigation Made Easy**: A bottom navigation bar allows seamless transitions between different sections like Home, Add Recipe, and Notifications.

## Technology Stack

- **Language**: Java
- **Framework**: Android SDK
- **UI Structure**: Organized into functional folders (`add`, `home`, `notifications`) for modular development.
- **Navigation**: Powered by Android’s Navigation Component and Material Design principles, enabling a smooth user experience.

## Architecture

### Entities:
- **Ingredient**: Represents individual ingredients with:
  - ID
  - Name
  - Category
- **Recipe**: Encapsulates all recipe details, including:
  - Ingredients
  - Tools
- **User**: Manages user credentials and profile data.
- **Saved Recipes**: Links users to their favorite recipes.

### Main Activity:
- Serves as the entry point, integrating a Bottom Navigation View for accessing core functionalities.

---

