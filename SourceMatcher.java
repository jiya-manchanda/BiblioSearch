import java.util.*;
import java.io.*;

public class SourceMatcher {

    public static void main(String[] args) {
        List<String> filesToCompare = getFilePaths();
        compareBibliographies(filesToCompare);
    }

    private static void welcomeMessage() {
        System.out.println("Welcome to the Bibliography Comparison Program, BiblioSearch!");
        System.out.println("This program compares the bibliographies of selected files (research papers).");
        System.out.println("Please follow the instructions to choose the files you want to compare.");
        System.out.println("The program will show you which are the most common sources found in the bibliographies of the files you select.\n");
    }

    private static List<String> getFilePaths() {
        welcomeMessage();

        Map<Integer, String> fileMapping = new HashMap<>();
        fileMapping.put(1, "paper_1.txt");
        fileMapping.put(2, "paper_2.txt");
        fileMapping.put(3, "paper_3.txt");
        fileMapping.put(4, "paper_4.txt");
        fileMapping.put(5, "paper_5.txt");
        fileMapping.put(6, "paper_6.txt");
        fileMapping.put(7, "paper_7.txt");

        List<String> filePaths = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numFiles = 0;

        // Get the number of files from the user, ensuring it is between 2 and 7
        while (true) {
            try {
                System.out.print("Enter the number of files (2-7): ");
                numFiles = Integer.parseInt(scanner.nextLine());
                if (numFiles >= 2 && numFiles <= 7) {
                    break;
                } else {
                    System.out.println("Error: Please enter a number between 2 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
            }
        }

        // Display available file options
        System.out.println("Choose file(s) from the following options:");
        for (Map.Entry<Integer, String> entry : fileMapping.entrySet()) {
            System.out.println("Type " + entry.getKey() + " for " + entry.getValue());
        }

        // Get user choices for each file
        for (int i = 0; i < numFiles; i++) {
            while (true) {
                System.out.print("Enter your choice for file " + (i + 1) + ": ");
                String fileChoiceInput = scanner.nextLine().trim();
                if (fileChoiceInput.isEmpty()) {
                    System.out.println("Error: You must provide a choice.");
                    continue;
                }

                try {
                    int fileChoice = Integer.parseInt(fileChoiceInput);
                    if (fileMapping.containsKey(fileChoice)) {
                        filePaths.add(fileMapping.get(fileChoice));
                        break;
                    } else {
                        System.out.println("Error: Invalid choice. Please choose a number between 1 and 7.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Please enter a number.");
                }
            }
        }

        return filePaths;
    }

    private static int findBibliographyStart(String content) {
        String[] keywords = {"bibliography", "works cited", "references", "citations"};
        int index = -1;

        for (String keyword : keywords) {
            int startIndex = content.toLowerCase().indexOf(keyword);
            if (startIndex != -1 && (index == -1 || startIndex < index)) {
                index = startIndex;
            }
        }

        return index;
    }

    private static List<String> extractBibliography(String filePath) {
        List<String> sources = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            int bibliographyStart = findBibliographyStart(content.toString());
            if (bibliographyStart != -1) {
                String[] bibliographyLines = content.substring(bibliographyStart).split("\n");
                for (String bibliographyLine : bibliographyLines) {
                    if (!bibliographyLine.trim().isEmpty()) {
                        sources.add(bibliographyLine.trim());
                    } else {
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: An error occurred while reading the file: " + filePath);
        }
        return sources;
    }

    private static void compareBibliographies(List<String> files) {
        Map<String, List<String>> bibliographies = new HashMap<>();
        for (String filePath : files) {
            List<String> bibliography = extractBibliography(filePath);
            bibliographies.put(filePath, bibliography);
        }

        Set<String> commonSources = new HashSet<>(bibliographies.get(files.get(0)));
        String[] keywords = {"bibliography", "works cited", "references", "citations"};

        List<String> commonSourcesList = new ArrayList<>(commonSources);
        for (String keyword : keywords) {
            commonSourcesList.removeIf(source -> source.toLowerCase().startsWith(keyword));
        }

        commonSources = new HashSet<>(commonSourcesList);

        for (List<String> bibliography : bibliographies.values()) {
            commonSources.retainAll(bibliography);
        }

        System.out.println("\nCommon Sources in the selected files:");
        for (String source : commonSources) {
            System.out.println("- " + source);
        }

        System.out.println("\nSummary:");
        for (Map.Entry<String, List<String>> entry : bibliographies.entrySet()) {
            String fileName = entry.getKey().split("\\.")[0];
            System.out.println("Number of sources in " + fileName + ": " + entry.getValue().size());
        }

        System.out.println("Number of common sources: " + commonSources.size());
    }
}
