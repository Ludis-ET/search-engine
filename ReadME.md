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
git clone https://github.com/your-username/java-search-engine.git
cd java-search-engine
```