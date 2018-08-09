/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package litery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Animka
 */
public class FileOperations {

    int numberOfLetters;
    long result;
    String fileName;
    char[] jasSurname,malgosiaSurname;

    public FileOperations(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        getData();
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public char[] getJasSurname() {
        return jasSurname;
    }

    public char[] getMalgosiaSurname() {
        return malgosiaSurname;
    }

    public void setResult(long result) {
        this.result = result;
    }
    
    public void saveResult(String fileName) throws FileNotFoundException{
        PrintWriter save=new PrintWriter(fileName);
        save.print(this.result);
        save.close();
    }

    private void getData() throws FileNotFoundException {
        File input = new File(fileName);
        Scanner scanner = new Scanner(input);
        numberOfLetters = Integer.parseInt(scanner.nextLine());
        jasSurname = scanner.nextLine().toCharArray();
        malgosiaSurname = scanner.nextLine().toCharArray();
    }
    

}
