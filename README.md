# Search Engine

This project is a simple search engine implemented in Java. It allows users to search for text within files, with features such as spell correction and synonym handling.

## Features

- **Spell Correction**: Automatically corrects common spelling mistakes in search queries.
- **Synonym Handling**: Searches for synonyms of the query terms to provide more comprehensive results.
- **File Handling**: Supports multiple file types including `.txt`, `.csv`, `.xml`, and `.json`.
- **Web Scraping**: Scrapes content from websites using specified CSS queries.
- **Graphical User Interface**: Provides a user-friendly interface for performing searches and viewing results.

## Project Structure

- `src/engine/core`: Contains the core search engine logic.
- `src/engine/localdb`: Handles file operations and indexing.
- `src/engine/utils`: Utility classes for spell checking and synonym handling.
- `src/engine/web`: Web scraping and website handling.
- `src/gui`: Graphical user interface components.
- `src`: Main application entry point.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- [Jsoup library](https://jsoup.org/) for web scraping

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/ludis-et/search-engine.git
    cd search-engine
    ```

2. Build the project using your preferred IDE or build tool.

### Running the Application

1. Navigate to the `src` directory:
    ```sh
    cd src
    ```

2. Compile and run the `App.java` file:
    ```sh
    javac App.java
    java App
    ```

### Usage

- Launch the application to open the search engine UI.
- Type your search query in the search bar.
- View the search results in the results area.
- Click on a result to view the file details.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Jsoup](https://jsoup.org/) for HTML parsing and web scraping.
