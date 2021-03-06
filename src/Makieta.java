
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ewa
 */
public class Makieta extends javax.swing.JFrame {

    /**
     * Creates new form Makieta
     */
    public Makieta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooserOtworzPlik = new javax.swing.JFileChooser();
        jFileChooserZapiszPlik = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonOtworz = new javax.swing.JButton();
        jButtonZapisz = new javax.swing.JButton();
        jButtonZakoncz = new javax.swing.JButton();
        jButtonWczytajParagon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaProdukty = new javax.swing.JTextArea();

        jFileChooserZapiszPlik.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFileChooserZapiszPlik.setApproveButtonText("Zapisz");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonOtworz.setText("Otwórz plik");
        jButtonOtworz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtworzActionPerformed(evt);
            }
        });

        jButtonZapisz.setText("Zapisz plik");
        jButtonZapisz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZapiszActionPerformed(evt);
            }
        });

        jButtonZakoncz.setText("Zakończ");
        jButtonZakoncz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZakonczActionPerformed(evt);
            }
        });

        jButtonWczytajParagon.setText("Wycztaj paragon");
        jButtonWczytajParagon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWczytajParagonActionPerformed(evt);
            }
        });

        jTextAreaProdukty.setColumns(20);
        jTextAreaProdukty.setRows(5);
        jScrollPane2.setViewportView(jTextAreaProdukty);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonOtworz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonWczytajParagon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonZapisz)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                        .addComponent(jButtonZakoncz)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonWczytajParagon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOtworz)
                    .addComponent(jButtonZapisz)
                    .addComponent(jButtonZakoncz))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOtworzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtworzActionPerformed
        int odpowiedz = jFileChooserOtworzPlik.showOpenDialog(this);
        if (odpowiedz == jFileChooserOtworzPlik.APPROVE_OPTION) {
            File file = jFileChooserOtworzPlik.getSelectedFile();
            try {
                jTextArea1.read( new FileReader( file.getAbsolutePath() ), null );
            // test dla pattern
                String str = FileUtils.readFileToString(file, "UTF-8");
                findPattern(str);
            // koniec testu dla pattern
            } catch (IOException ex) {
                System.out.println("Nie mogę otworzyć pliku: "+file.getAbsolutePath());
                System.out.println("Problem: "+ex);
            }
        }
 
    }//GEN-LAST:event_jButtonOtworzActionPerformed

    private void jButtonZapiszActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZapiszActionPerformed
        int odpowiedz = jFileChooserZapiszPlik.showSaveDialog(this);
        if (odpowiedz == jFileChooserZapiszPlik.APPROVE_OPTION) {
            File file = jFileChooserZapiszPlik.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file);
                out.write(jTextArea1.getText());
                out.close();               
            } catch (IOException ex) {
                System.out.println("Nie mogę zapisać pliku: "+file.getAbsolutePath());
                System.out.println("Problem: "+ex);
            }
        }
    }//GEN-LAST:event_jButtonZapiszActionPerformed

    private void jButtonZakonczActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZakonczActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonZakonczActionPerformed

    private void jButtonWczytajParagonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWczytajParagonActionPerformed

        int odpowiedz = jFileChooserOtworzPlik.showOpenDialog(this);
        if (odpowiedz == jFileChooserOtworzPlik.APPROVE_OPTION) {
            File file = jFileChooserOtworzPlik.getSelectedFile();
            Tesseract instance = new Tesseract();
            instance.setDatapath("C:\\Users\\ewa\\Desktop\\tesseract");
            instance.setLanguage("pol");
            String fullText;
            try {
                fullText = instance.doOCR(file);
                jTextArea1.append(fullText);
                //zapiszOCRdoPliku(fullText);
                //findPattern(fullText);
                //zapisDoPliku(fullText);
                //czytaniePliku();
                FileWriter fw = new FileWriter("paragon.txt");
                fw.write(fullText);
                fw.close();
                findPattern(fullText);

                    
                
            } catch (TesseractException ex) {
                Logger.getLogger(Makieta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Makieta.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        
    }//GEN-LAST:event_jButtonWczytajParagonActionPerformed
    
    private void zapisDoPliku(String fullText) throws IOException {

        FileWriter fw = new FileWriter("paragon.txt");
        fw.write(fullText);
        fw.close();
    }
    
    private void czytaniePliku() throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("paragon.txt");
	BufferedReader br = new BufferedReader(fr);
        
	String s;
	while((s = br.readLine()) != null && findPatternEnd(s) == true) {
            jTextAreaProdukty.append(s + "\n");
	}
	fr.close();
    }
    private void findPattern(String text) throws IOException {

        String foundPattern = null;
        Pattern pattern = Pattern.compile("P[AH]R[AH]GON");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            foundPattern = matcher.group(0);
            
            jTextAreaProdukty.append(foundPattern); //prints /{item}/
            czytaniePliku();
        } else {
            jTextAreaProdukty.append("Nie znaleziono wzorca");
        }
        //return foundPattern;
    }
    
//Sprzed. opodatk. H 3,58.
    
    public void zapiszOCRdoPliku(String text) {
        
        try {
            PrintWriter zapis = new PrintWriter("OCRdoPliku.txt");
            zapis.println(text);
            zapis.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nie mogę zapisać pliku");
            System.out.println("Problem: "+ex);
        }  
    }
    
    public void ScannerFindInLine(File file) throws FileNotFoundException {
        
        Scanner scan = new Scanner(file);
        // iterate through the file line by line
	while(scan.hasNextLine()){
	// scan for names on the content of the file			
            String str = scan.findInLine("P[AH]R[AH]GON");
            if(str != null){
               scan.hasNextLine();
               jTextAreaProdukty.append("aaa");
            // print the string content that satisfies the pattern 
            // specified on the method argument
            // System.out.println(str);
            }
            // advance to the next line
            scan.nextLine();
	}
	// close the scanner object;		
	scan.close();	

    }
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Makieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Makieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Makieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Makieta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Makieta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOtworz;
    private javax.swing.JButton jButtonWczytajParagon;
    private javax.swing.JButton jButtonZakoncz;
    private javax.swing.JButton jButtonZapisz;
    private javax.swing.JFileChooser jFileChooserOtworzPlik;
    private javax.swing.JFileChooser jFileChooserZapiszPlik;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextAreaProdukty;
    // End of variables declaration//GEN-END:variables
}
