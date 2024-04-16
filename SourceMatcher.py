def welcome_message():
  """
  Display a welcome message to guide the user.
  """

  print("Welcome to the Bibliography Comparison Program!")
  print(
      "This program compares the bibliographies of selected files (research papers)."
  )
  print(
      "Please follow the instructions to choose the files you want to compare."
  )
  print(
      "The program will show you which are the most common sources found in the bibliographies of the files you select.\n"
  )


def get_file_paths():
  """
  Get file paths based on user input.

  Returns:
  list: List of file paths.
  """

  welcome_message()

  # Define available files with corresponding numbers in a key for each value in the dictionary.
  file_mapping = {
      1: "paper_1.txt",
      2: "paper_2.txt",
      3: "paper_3.txt",
      4: "paper_4.txt",
      5: "paper_5.txt",
      6: "paper_6.txt",
      7: "paper_7.txt"
  }

  file_paths = []

  # Get the number of files from the user, ensuring it is between 2 and 7
  num_files = 0
  while True:
    try:
      num_files = int(input("Enter the number of files (2-7): "))
      if 2 <= num_files <= 7:
        break
      else:
        print("Error: Please enter a number between 2 and 7.")
    except ValueError:
      print("Error: Invalid input. Please enter a number.")

  # Display available file options
  print("Choose file(s) from the following options:")
  for key, value in file_mapping.items():
    print(f"Type {key} for {value}")

  # Get user choices for each file
  for i in range(num_files):
    while True:
      file_choice_input = input(
          f"Enter your choice for file {i + 1}: ").strip()
      if not file_choice_input:
        print("Error: You must provide a choice.")
        continue

      try:
        file_choice = int(file_choice_input)
        if file_choice in file_mapping:
          file_paths.append(file_mapping[file_choice])
          break  # Exit the loop if a valid choice is provided
        else:
          print(
              "Error: Invalid choice. Please choose a number between 1 and 7.")
          i -= 1  # Decrement i to re-enter the choice for the current file1
      except ValueError:
        print("Error: Invalid input. Please enter a number.")

  return file_paths


def find_bibliography_start(content):
  """
  Find the starting index of the bibliography section in the content.

  Arguments:
  content (str): The content of a file.

  Returns:
  int: The starting index of the bibliography section.
  """

  # Define possible keywords indicating the start of the bibliography section
  keywords = ['bibliography', 'works cited', 'references', 'citations']

  # Find the index of the first occurrence of any of the keywords
  index = -1
  for keyword in keywords:
    start_index = content.lower().find(keyword)
    if start_index != -1 and (index == -1 or start_index < index):
      index = start_index

  return index


def extract_bibliography(file_path):
  """
  Extract the bibliography section from a file.

  Arguments:
  file_path (str): The path of the file.

  Returns:
  list: List of bibliography sources.
  """

  # Open the file and extract the bibliography section
  file = None  # Initialize file variable to None
  try:
    file = open(file_path, 'r')
    content = file.read().lower()

    # Find the start index of the bibliography section
    bibliography_start = find_bibliography_start(content)

    if bibliography_start != -1:
      # Extract the bibliography section
      bibliography_text = content[bibliography_start:]

      # Split the bibliography text into individual lines
      bibliography_lines = bibliography_text.split('\n')

      # Filter out empty lines
      non_empty_lines = filter(lambda line: line.strip(), bibliography_lines)

      # Join lines until an empty line or the end of the document is encountered
      sources = []
      for line in non_empty_lines:
        if line:
          sources.append(line.strip())
        else:
          break

      file.close()
      return sources
    else:
      file.close()
      return []
  except FileNotFoundError:
    print(f"Error: File not found: {file_path}")
    return []
  finally:
    if file:
      file.close()


def compare_bibliographies(files):
  """
  Compare bibliographies of multiple files and display common sources.

  Arguments:
  files (list): List of file paths.
  """

  # Extract bibliographies from each file
  bibliographies = {}
  for file_path in files:
    bibliography = extract_bibliography(file_path)
    bibliographies[file_path] = bibliography

  # Find common sources across all files
  common_sources = set(bibliographies[files[0]])

  # Exclude starting keywords from common sources
  keywords = ['bibliography', 'works cited', 'references', 'citations']

  # Convert the set to a list for modification
  common_sources_list = list(common_sources)
  for keyword in keywords:
    common_sources_list = [
        source for source in common_sources_list
        if not source.lower().startswith(keyword)
    ]

  # Convert the list back to a set
  common_sources = set(common_sources_list)

  for bibliography in bibliographies.values():
    common_sources = common_sources.intersection(bibliography)

  # Display the common sources
  print("\nCommon Sources in the selected files:")
  for source in common_sources:
    print(f"- {source}")

  print("\nSummary:")
  for file_path, bibliography in bibliographies.items():
    file_name = file_path.split(".")[0]
    print(f"Number of sources in {file_name}: {len(bibliography)}")

  print(f"Number of common sources: {len(common_sources)}")


def main():
  """
  Main function to run the program.
  """

  files_to_compare = get_file_paths()
  compare_bibliographies(files_to_compare)


main()
