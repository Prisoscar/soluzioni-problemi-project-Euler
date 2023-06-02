package eu.prisoscar.euler1.soluzioni;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/*
Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?
 */
public class Prbl_15_LatticePaths {

    private static final int GRID_SIZE = 20;
    private static final String SHEET_NAME = "Combinations";
    private static  final int LIMIT = 1048574/2;
    //private static  final int LIMIT = 1048575;

    //Pascal triangle method
    public static long getSolution() {
        List<Long> pascalTriangleLastLine;
        List<Long> pascalTriangleActualLine = Arrays.asList(1L, 2L, 1L);
        for (int i = 2; i < GRID_SIZE * 2; i++){
            pascalTriangleLastLine = new ArrayList<>(pascalTriangleActualLine);
            pascalTriangleActualLine = new ArrayList<>();
            pascalTriangleActualLine.add(1L);
            for (int j = 0; j < pascalTriangleLastLine.size() -1 ; j++){
                pascalTriangleActualLine.add(pascalTriangleLastLine.get(j) + pascalTriangleLastLine.get(j + 1));
            }
            pascalTriangleActualLine.add(1L);
        }
        return pascalTriangleActualLine.stream().max(Comparator.comparing(Long::valueOf)).get();
    }
/*
    step 1 create new file an put first 2 cases 0 and 1
    step 2 change name of file in  temporary
    step 3 take elements from temporary once per time and add other 0 or 1 and put in new file
    return size of last sheet
 */
    //excel on multi sheets
    //heap out of memory exception
    /*
    public static long getSolution() throws IOException{
        int jLimitCounter = 0;
        int rowLimitCounter = 0;
        long solution = 1;
        long rowCounter;
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "Combinations.xlsx";
        String temporaryFileLocation = path.substring(0, path.length() - 1) + "Temporary.xlsx";
        Workbook writeWorkbook;
        Workbook readWorkbook;
        FileInputStream readingFile;
        String analyzedPath;
        String newPath;
        FileOutputStream outputStream;
        //if files already exists delete them
        if (new File (temporaryFileLocation).exists()) new File (temporaryFileLocation).delete();
        if (new File (fileLocation).exists()) new File (fileLocation).delete();
        //initialize first two elements 0 and 1
        writeWorkbook = getWriteWorkbook();

        outputStream = new FileOutputStream(fileLocation);
        Row firstWriteRow1 = writeWorkbook.getSheetAt(0).createRow(0);
        Cell firstWriteCell1 = firstWriteRow1.createCell(0);
        firstWriteCell1.setCellValue("0");
        Row firstWriteRow2 = writeWorkbook.getSheetAt(0).createRow(1);
        Cell firstWriteCell2 = firstWriteRow2.createCell(0);
        firstWriteCell2.setCellValue("1");
        writeWorkbook.write(outputStream);
        writeWorkbook.close();
        outputStream.close();
        //File writingFile = new File(fileLocation);
        //create all possible paths for 20 X 20 grid, considering 0 = 1 step down and 1 = one step right
        for (int i = 1; i < 2 * GRID_SIZE; i++) {
            System.out.println(i);
            File writingFile = new File(fileLocation);
            if (writingFile.exists()) {
                writingFile.renameTo(new File(temporaryFileLocation));
            }
            readingFile = new FileInputStream(temporaryFileLocation);
            readWorkbook = getReadWorkbook(readingFile);
            rowCounter = -1;
            rowLimitCounter = 0;
            jLimitCounter = 0;
            outputStream = new FileOutputStream(fileLocation);
            writeWorkbook = getWriteWorkbook();
            for (int j = 0; j <= solution; j++){
                if(((Double)((double)(j - 1) / LIMIT)).intValue() > jLimitCounter) jLimitCounter++;
                analyzedPath = jLimitCounter > 0 ? readWorkbook.getSheetAt(jLimitCounter).getRow(j - 1 - (jLimitCounter * LIMIT)).getCell(0).toString() : readWorkbook.getSheetAt(jLimitCounter).getRow(j).getCell(0).toString();

                if (analyzedPath.chars().filter(ch -> ch == '0').count() < GRID_SIZE) {
                    Row writeRow1 = rowLimitCounter > 0 ? writeWorkbook.getSheetAt(rowLimitCounter).createRow((int)(rowCounter - (rowLimitCounter * LIMIT))) : writeWorkbook.getSheetAt(rowLimitCounter).createRow((int)(rowCounter + 1));
                    Cell writeCell1 = writeRow1.createCell(0);
                    newPath = analyzedPath + "0";
                    writeCell1.setCellValue(newPath);
                    rowCounter++;
                    if(((Double)((double)(rowCounter) / LIMIT)).intValue() > rowLimitCounter) rowLimitCounter++;
                }
                if (analyzedPath.chars().filter(ch -> ch == '1').count() < GRID_SIZE) {
                    Row writeRow2 = rowLimitCounter > 0 ? writeWorkbook.getSheetAt(rowLimitCounter).createRow((int)(rowCounter - (rowLimitCounter * LIMIT))) : writeWorkbook.getSheetAt(rowLimitCounter).createRow((int)(rowCounter + 1));
                    Cell writeCell2 = writeRow2.createCell(0);
                    newPath = analyzedPath + "1";
                    writeCell2.setCellValue(newPath);
                    rowCounter++;
                    if(((Double)((double)(rowCounter) / LIMIT)).intValue() > rowLimitCounter) rowLimitCounter++;
                }
            }
            writeWorkbook.write(outputStream);
            writeWorkbook.close();
            readWorkbook.close();
            readingFile.close();
            outputStream.close();
            solution = rowCounter;
            if (new File (temporaryFileLocation).exists()) new File (temporaryFileLocation).delete();
        }




        return solution + 1;
    }

    private static Workbook getWriteWorkbook (){
        Workbook workbook = new XSSFWorkbook();
        for(int i = 0; i < 25; i++){
            workbook.createSheet();
        }
        return workbook;
    }

    private static Workbook getReadWorkbook(FileInputStream file) throws IOException{
        return new XSSFWorkbook(file);
    }
    */
    //on list on RAM memory
    //heap out of memory exception
    /*
    public static int getSolution(){

        int solution;
        List<List<Integer>> possiblePathsList = new ArrayList<>();
        List<Integer> latticePath;
        List<List<Integer>> temporaryPossiblePathsList;
        //initialize first move
        possiblePathsList.add(Arrays.asList(0));
        possiblePathsList.add(Arrays.asList(1));
        for (int i = 1; i < 2 * GRID_SIZE; i++){
            temporaryPossiblePathsList = new ArrayList<>(possiblePathsList);
            possiblePathsList = new ArrayList<>();
            System.out.println(i);
            for (List<Integer> analyzedList : temporaryPossiblePathsList){
                latticePath = new ArrayList<>(analyzedList);
                latticePath.add(0);

                if(Collections.frequency(latticePath, 0) <= GRID_SIZE) possiblePathsList.add(latticePath);
                latticePath = new ArrayList<>(analyzedList);
                latticePath.add(1);
                if(Collections.frequency(latticePath, 1) <= GRID_SIZE) possiblePathsList.add(latticePath);
            }
        }
        solution = possiblePathsList.size();
        return solution;
    }
    */
    //excel on multi cells
    //heap out of memory exception
    /*
    public static long getSolution() throws IOException{
        int jLimitCounter = 0;
        int rowLimitCounter = 0;
        long solution = 1;
        long rowCounter;
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "Combinations.xlsx";
        String temporaryFileLocation = path.substring(0, path.length() - 1) + "Temporary.xlsx";
        Workbook writeWorkbook;
        Workbook readWorkbook;
        FileInputStream readingFile;
        String analyzedPath;
        String newPath;
        FileOutputStream outputStream;
        //if files already exists delete them
        if (new File (temporaryFileLocation).exists()) new File (temporaryFileLocation).delete();
        if (new File (fileLocation).exists()) new File (fileLocation).delete();
        //initialize first two elements 0 and 1
        writeWorkbook = getWriteWorkbook();

        outputStream = new FileOutputStream(fileLocation);
        Row firstWriteRow1 = writeWorkbook.getSheet(SHEET_NAME).createRow(0);
        Cell firstWriteCell1 = firstWriteRow1.createCell(0);
        firstWriteCell1.setCellValue("0");
        Row firstWriteRow2 = writeWorkbook.getSheet(SHEET_NAME).createRow(1);
        Cell firstWriteCell2 = firstWriteRow2.createCell(0);
        firstWriteCell2.setCellValue("1");
        writeWorkbook.write(outputStream);
        writeWorkbook.close();
        outputStream.close();
        //File writingFile = new File(fileLocation);
        //create all possible paths for 20 X 20 grid, considering 0 = 1 step down and 1 = one step right
        for (int i = 1; i < 2 * GRID_SIZE; i++) {
            System.out.println(i);
            File writingFile = new File(fileLocation);
            if (writingFile.exists()) {
                writingFile.renameTo(new File(temporaryFileLocation));
            }
            readingFile = new FileInputStream(temporaryFileLocation);
            readWorkbook = getReadWorkbook(readingFile);
            rowCounter = -1;
            rowLimitCounter = 0;
            jLimitCounter = 0;
            outputStream = new FileOutputStream(fileLocation);
            writeWorkbook = getWriteWorkbook();
            for (int j = 0; j <= solution; j++){
                if(((Double)((double)(j - 1) / LIMIT)).intValue() > jLimitCounter) jLimitCounter++;

                analyzedPath = jLimitCounter > 0 ? readWorkbook.getSheet(SHEET_NAME).getRow(j - 1 - (jLimitCounter * LIMIT)).getCell(jLimitCounter).toString() : readWorkbook.getSheet(SHEET_NAME).getRow(j).getCell(jLimitCounter).toString();

                if (analyzedPath.chars().filter(ch -> ch == '0').count() < GRID_SIZE) {
                    Row writeRow1 = rowLimitCounter > 0 ? writeWorkbook.getSheet(SHEET_NAME).getRow((int)(rowCounter - (rowLimitCounter * LIMIT))) : writeWorkbook.getSheet(SHEET_NAME).createRow((int)(rowCounter + 1));
                    Cell writeCell1 = writeRow1.createCell(rowLimitCounter);
                    newPath = analyzedPath + "0";
                    writeCell1.setCellValue(newPath);
                    rowCounter++;
                    if(((Double)((double)(rowCounter) / LIMIT)).intValue() > rowLimitCounter) rowLimitCounter++;
                }
                if (analyzedPath.chars().filter(ch -> ch == '1').count() < GRID_SIZE) {

                    Row writeRow2 = rowLimitCounter > 0 ? writeWorkbook.getSheet(SHEET_NAME).getRow((int)(rowCounter - (rowLimitCounter * LIMIT))) : writeWorkbook.getSheet(SHEET_NAME).createRow((int)(rowCounter + 1));
                    Cell writeCell2 = writeRow2.createCell(rowLimitCounter);
                    newPath = analyzedPath + "1";
                    writeCell2.setCellValue(newPath);
                    rowCounter++;
                    if(((Double)((double)(rowCounter) / LIMIT)).intValue() > rowLimitCounter) rowLimitCounter++;
                }
            }
            writeWorkbook.write(outputStream);
            writeWorkbook.close();
            readWorkbook.close();
            readingFile.close();
            outputStream.close();
            solution = rowCounter;
            if (new File (temporaryFileLocation).exists()) new File (temporaryFileLocation).delete();
        }




        return solution + 1;
    }

    private static Workbook getWriteWorkbook (){
        Workbook workbook = new XSSFWorkbook();
        workbook.createSheet(SHEET_NAME);
        return workbook;
    }

    private static Workbook getReadWorkbook(FileInputStream file) throws IOException{
        return new XSSFWorkbook(file);
    }
     */
}
