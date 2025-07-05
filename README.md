# Culinary Companion – Mobile Computing Coursework 2

This repository contains the final, fully working version of the **Culinary Companion** mobile application for the Mobile Computing module at Birkbeck.

**Module:** Mobile Computing  
**Student:** Ivaylo Donchev (idonch01)


## Coursework Context

This repository includes:
* The final version for **Coursework 2**, developed step by step with proper version control commits.
* The original `CulinaryCompanion.zip` file from **Coursework 1** is still kept in the repository for reference and comparison. The CW2 project fully replaces that initial ZIP by providing the actual source files with full functionality and structure.



## Coursework 2 Requirements

This submission covers all specified CW2 requirements:

* Create, view, edit, and delete recipe entries.
* Store recipes locally using a Room Database.
* Use a ViewModel for managing data.
* Display all recipes in a RecyclerView.
* Allow editing and deleting recipes by tapping a recipe item.
* Support categories: Breakfast, Brunch, Lunch, Dinner, Desserts, Other.
* Developed using Views only (no Compose).
* Developed and committed in logical steps using GitHub for version control.



## What's Implemented

* Room Database: Entity, DAO, Database class
* ViewModel: Manages live recipe data
* RecyclerView: Displays all recipes
* Activities:
  * DashboardActivity: shows all recipes
  * RecipeDetailsActivity: add, edit, delete a recipe
* Layouts: XML layouts matching the coursework wireframes
* No Compose: Classic Views-only Android app


## How to Run

1. Download or clone the repository.
2. Open in Android Studio.
3. Allow Gradle sync to complete.
4. Run the app on an emulator or physical device.
5. Use the FloatingActionButton to add new recipes.
6. Click any recipe to edit or delete it.


## Development Notes

* This version addresses all previous feedback:
  * Uses correct Views Activities (no Compose)
  * Builds and runs successfully
  * Proper Room, ViewModel, RecyclerView integration
* Commit history shows clear step-by-step progress:
  * Project setup
  * Room database layer
  * ViewModel
  * UI layouts
  * Activities and adapter
  * Final tweaks and build config



Developed for Mobile Computing Coursework 2.
Thank you for reviewing.  


