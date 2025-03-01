# 📝 Notes_Android: A Simple Note Manager with Task Reminders

Welcome to **Notes_Android**! This project is designed to help you manage your notes and tasks with ease, all wrapped up in a user-friendly Android application. Here's what you need to know:

## 🚀 Project Overview

- **Language**: Java
- **Database**: SQLite
- **Purpose**: To create a simple yet effective note manager with task reminders.

## 🌟 Key Features

### Classes:
- **@ListadoActivity** 📋: Displays the list of tasks.
- **@CrearNotaActivity** ✍️: Allows creation of notes which are then shown in ListadoActivity.
- **@BorrarNotaActivity** 🗑️: Deletes notes, either individually or all at once.
- **@VerNotaActivity** 👀: Reads the notes created in CrearNotaActivity.
- **@DataBaseSQL** 💾: Manages the SQLite database with the table structure for storing notes.
- **@StartActivity** 🏠: The initial screen of the app, showing the database name, and after 2 seconds of inactivity, it transitions to the list of notes.
- **@NotasAdapter** 🔧: A custom adapter for the note list in ListadoActivity, displaying note text in a TextView.

### Layouts:
- **activity_borrar_notas.xml** 🗑️: Defines the layout for BorrarNotasActivity.
- **activity_crear_notas.xml** ✍️: Defines the layout for CrearNotaActivity.
- **activity_ver_nota.xml** 👀: Defines the layout for VerNotaActivity.
- **app_bar_listado.xml** 🧰: Defines the menu options bar for ListadoActivity.
- **listado_activity.xml** 📋: Defines the layout for ListadoActivity.
- **menu_listado.xml** 🍔: Contains menu items like 'Create' and 'Options' for ListadoActivity.

## 🛠️ How to Use

1. **Clone the Repository**: 
git clone https://github.com/Ornella-Gigante/Notes_Android.git

text

2. **Open in Android Studio**: Import the project into Android Studio.

3. **Build and Run**: Build the project and run it on an emulator or physical device.

4. **Explore**: 
- Create notes in **CrearNotaActivity**.
- View your notes in **ListadoActivity**.
- Delete notes in **BorrarNotaActivity**.
- Read notes in **VerNotaActivity**.

## 📚 Learning and Contribution

This project is a great starting point for learning Android development with Java, SQLite database management, and UI design. Feel free to:

- **Fork** the repository and make your own changes.
- **Contribute** by submitting pull requests with improvements or new features.
- **Report Issues** if you find any bugs or have suggestions for enhancements.

## 👩‍💻 Author

- **Ornella Gigante** - *Creator and Maintainer*

## 📜 License

This project is open-sourced under the [MIT License](LICENSE). Feel free to use, modify, and distribute as per the license terms.

## 🌐 Connect

- [GitHub](https://github.com/Ornella-Gigante)
- [LinkedIn](https://www.linkedin.com/in/ornella-gigante/)

Let's make note-taking fun and efficient! 📝✨
