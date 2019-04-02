
import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ewa
 */
public class tess {
    
    
    public static void main(String[] args) throws Exception {
/*File imageFile = new File("C:\\Users\\ewa\\Desktop\\biedronka_kod_systemowy.tif");
Tesseract instance = new Tesseract(); //
 
try {
 
String result = instance.doOCR(imageFile);
System.out.println(result);
 
} catch (TesseractException e) {
System.err.println(e.getMessage());
}
 */
        String inputFilePath = "C:\\Users\\ewa\\Desktop\\tesseract\\biedronka_kod_systemowy.tif";
        Tesseract instance = new Tesseract();
        instance.setDatapath("C:\\Users\\ewa\\Desktop\\tesseract\\");
        instance.setLanguage("pol");
        
        String fullText = instance.doOCR(new File(inputFilePath));
        
        System.out.println(fullText);
}
}
