# Java Search Engine

A simple yet powerful **Search Engine** built in **Java** that indexes text and PDF documents, allowing users to search through them quickly and efficiently. This project demonstrates the power of Object-Oriented Programming (OOP) principles and Data Structures to solve real-world problems, offering features like auto-completion, relevance ranking, and pagination.

## 🚀 Features

- **Document Indexing**: Index text and PDF documents placed in the `db/` folder.
- **Relevance Ranking**: Search results are ranked by relevance to the user query.
- **Auto-Completion**: Provides suggestions as you type, based on indexed keywords.
- **Spell Checker**: Suggests corrections for common spelling mistakes in search queries.
- **Pagination**: Search results are paginated for better user experience with large data sets.
- **Real-Time Folder Monitoring**: Automatically detects new files added to the `db/` folder and reindexes them.
- **Error Handling**: Custom exceptions for file processing errors and invalid queries.
- **Command-Line Interface (CLI)**: User interacts with the search engine through the terminal.

## 🔧 Requirements

Before running the project, ensure that the following dependencies are installed:

- **Java 11+** (JDK)
- **Apache PDFBox** (for PDF processing)
- **VSCode** (for development, with the Java Extension Pack)

## ⚙️ Setup and Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Ludis-et/search-engine.git
cd search-engine
```

### 2. Install Dependencies

In order to work with additional libraries like Apache PDFBox (used for PDF text extraction), you need to download the JAR files and include them in your project.

1. Download **Apache PDFBox** from the official site: [PDFBox Download](https://pdfbox.apache.org/download.cgi).
2. Place the downloaded `.jar` files into the `lib/` folder inside the project directory. Create the `lib/` folder if it does not exist.
3. Ensure that the `classpath` is set to include these JAR files when compiling and running the project. In VSCode, this can be done by adding them to the `launch.json` configuration or manually specifying them in the terminal using the `-cp` flag.

For example, if using the terminal, you might run:

```bash
javac -cp ".:lib/pdfbox-app2.0.27.jar" -d bin src/com/searchengine/*.java
java -cp ".:bin:lib/pdfbox-app2.0.27.jar" com.searchengine.Main
```

### 3. Build and Run

To compile and run the project:

1. **Build the Project**: Open the terminal in VSCode or your preferred terminal and navigate to the project directory. Run the following command to compile the Java files:
   ```bash
   javac -d bin src/com/searchengine/*.java src/com/searchengine/engine/*.java src/com/searchengine/models/*.java src/com/searchengine/processors/*.java src/com/searchengine/utils/*.java src/com/searchengine/exceptions/*.java
   ```
2. **Run the Project**: After the project is compiled, you can run it using the java command.
   Ensure you're in the project directory and run the following:

```bash
java -cp ".:bin:lib/*" com.searchengine.Main
```

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 🙌 Contributing

Contributions are welcome! If you'd like to contribute, please fork the repository, create a new branch, and submit a pull request. All contributions must adhere to the code of conduct and coding style of the project.

---