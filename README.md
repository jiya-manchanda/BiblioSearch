# Bibliography Comparison Program

This program is a robust Python application designed to assist researchers, students, and academics by automating the process of comparing bibliographies across multiple research papers. By focusing on efficiency and accuracy, the program identifies common sources, providing insights into shared references among different files.

Here is the link to view how mathematical concepts, including set theory, were implemented in our code: https://www.canva.com/design/DAF1TCAkyfU/ywEaqUar1gn6GdJ6aCrgIw/view?utm_content=DAF1TCAkyfU&utm_campaign=designshare&utm_medium=link2&utm_source=uniquelinks&utlId=ha0c6fe0bc5

---

## Features

### Current Features

1. **User Guidance:**
   - The program begins with a welcoming message, offering clear instructions on how to navigate its functionalities.
   - Ensures an intuitive experience for users unfamiliar with programming.

2. **File Selection:**
   - Users can choose between 2 and 7 files from a predefined list of research papers.
   - The program validates user input to ensure only valid file paths are selected.

3. **Bibliography Extraction:**
   - The program identifies bibliography sections using a keyword-based approach. Keywords include "Bibliography," "Works Cited," "References," and "Citations."
   - Extracts and cleans bibliography entries for precise comparison.

4. **Comparison of Sources:**
   - Finds common sources across selected files, even if they are formatted differently.
   - Automatically excludes redundant header keywords from the comparison to ensure accuracy.

5. **Summary and Insights:**
   - Displays the total number of sources in each file.
   - Reports the number of common sources across selected files.
   - Summarizes findings in an easy-to-read format for further analysis.

---

## Planned Enhancements

The program aims to address existing limitations and expand its capabilities in the following ways:

### Citation Format Normalization

The current version of the program may overlook common sources if their citation formats differ slightly. For example, two entries referring to the same book might differ in author order, inclusion of editions, or formatting. To overcome this:

1. **Granular Parsing:**
   - Each source will be broken into individual components, such as:
     - **Title**
     - **Authors**
     - **Publication Date**
     - **Edition/Version**

2. **Standardized Reformatting:**
   - All components will be restructured into a consistent citation format before comparison.
   - This ensures that variations in formatting or minor details do not prevent the identification of common sources.

3. **Enhanced Accuracy:**
   - By addressing inconsistencies, the program will achieve a higher level of precision in recognizing shared references.

---

### Web Scraping for Bibliographic Data

Another significant enhancement involves integrating web scraping functionality. This feature will enable the program to extract bibliographic information directly from esteemed online philosophical resources, such as:

- **Stanford Encyclopedia of Philosophy**
- **Cambridge Companion of Philosophy**
- **Oxford Handbook of Philosophy**

#### Objectives:
1. Extract and organize bibliographic entries from these resources.
2. Automate the process of identifying widely recognized and influential books and authors in the field of philosophy.

#### Rationale:
- In independent research, guidance from professors or mentors is often limited.
- Automating the comparison of bibliographies reduces the need for manual parsing, freeing up time to focus on analyzing key contributions to philosophical discourse.

#### Challenges:
- Web scraping requires specialized techniques to navigate and extract structured data from websites.
- Currently, this feature is in the planning stage, as implementation requires further skill development.

---

## Motivation

The program was developed to address the challenges faced in academic research, particularly in identifying influential literature. Key motivations include:

1. **Streamlining Research:**
   - Automates the identification of overlapping references in research papers, saving time and effort.

2. **Optimizing Independent Study:**
   - In scenarios where mentorship is limited, the program offers a systematic way to identify key contributors in a field.

3. **Improving Accuracy:**
   - Enhancements like citation normalization and web scraping will ensure more reliable results.

---

## Testing Strategy

A thorough testing framework has been outlined to ensure the program performs as expected in diverse scenarios:

### Input Validation
- Test with valid and invalid inputs for the number of files (e.g., 1, 8, or non-numeric values).
- Verify that the program handles incorrect or missing inputs gracefully.

### File Selection
- Test with a variety of file combinations to confirm correct extraction of file paths.
- Check for appropriate handling of non-existent or inaccessible files.

### Bibliography Extraction
- Create test files with different structures, ensuring the program accurately identifies the start of bibliography sections using defined keywords.
- Validate that extracted entries match the content within the files.

### Comparison of Bibliographies
- Test with files containing:
  - Completely unique sources.
  - Partially overlapping sources.
  - Completely identical sources.
- Confirm exclusion of redundant headers like "References."

### User Interface and Display
- Test user prompts for clarity and usability.
- Verify that displayed results and summaries are accurate and easy to understand.

### Edge Cases
- Handle minimum (2) and maximum (7) file selections.
- Test with empty files and bibliography sections to ensure the program responds appropriately.

### Integration Testing
- Simulate end-to-end scenarios, combining various input cases and file types.

### Exception Handling
- Introduce deliberate errors (e.g., missing files, corrupted content) to verify robust error handling.

### Future Web Scraping Tests (Post-Implementation)
- Provide URLs from targeted online philosophical resources.
- Verify successful extraction of bibliographic entries from the websites.

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
