package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_RESET = "\u001B[0m";

    public static void main(String[] args) {
        String csvPath = "dataset/dataset.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvPath));
            String headerRow = reader.readLine();
            if (headerRow == null) {
                System.out.println("CSV file is empty.");
                return;
            }
            String[] fields = headerRow.split(",");
            System.out.print("=== Data Preview ===\n\n");
            System.out.print(COLOR_GREEN + "Columns: " + COLOR_RESET);
            for (int i = 0; i < fields.length; i++) {
                System.out.print(COLOR_GREEN + fields[i] + COLOR_RESET);
                if (i < fields.length - 1) System.out.print("    ");
            }
            System.out.println();
            System.out.println(COLOR_GREEN + "Number of columns: " + fields.length + COLOR_RESET);
            String row;
            int rowCount = 0;
            int displayCount = 0;
            System.out.println(COLOR_GREEN + "First 5 records:" + COLOR_RESET);
            while ((row = reader.readLine()) != null) {
                if (displayCount < 5) {
                    String[] data = row.split(",");
                    for (int i = 0; i < data.length; i++) {
                        System.out.print(COLOR_RED + data[i] + COLOR_RESET);
                        if (i < data.length - 1) System.out.print("    ");
                    }
                    System.out.println();
                    displayCount++;
                }
                rowCount++;
            }
            System.out.println(COLOR_GREEN + "Total records (excluding header): " + rowCount + COLOR_RESET);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
