# BiblioSearch: The Bibliography Comparison Program

This repository contains a Python program to compare the bibliographies of selected research papers. The program extracts the bibliography sections from the provided files and identifies the most common sources across all selected files.

---

## Features

- **User-Friendly Guidance:** Welcomes users with a clear explanation of the program's purpose.
- **File Selection:** Allows users to select between 2 to 7 research papers for comparison.
- **Bibliography Extraction:** Automatically extracts the bibliography section using keywords like "Bibliography," "Works Cited," "References," and "Citations."
- **Comparison of Sources:** Identifies and displays common sources from the bibliographies of the selected files.
- **Detailed Summary:** Provides the total number of sources in each file and the number of common sources across the files.

---

## How It Works

### 1. **Welcome Message**
Guides the user with a brief overview of the program.

### 2. **File Selection**
- Users can select up to 7 research papers from a predefined list.
- The program ensures only valid file selections are made.

### 3. **Bibliography Extraction**
- The program identifies the bibliography section using common keywords.
- It extracts and cleans the bibliography lines for comparison.

### 4. **Comparison**
- The program compares the bibliographies of the selected files.
- It excludes redundant headers or keywords from the comparison.

### 5. **Summary**
- Displays common sources found in the selected files.
- Provides a summary of the number of sources in each file and the total common sources.

---

## Requirements

- Python 3.6 or later

---

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/bibliography-comparison.git
   cd bibliography-comparison

2. Run the program:

    python bibliography_comparison.py
   
3. Follow the on-screen instructions to select files and view the comparison results.
