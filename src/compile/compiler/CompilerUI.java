/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compiler;

import compile.compilersource.CompilerHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author chris
 */
public class CompilerUI extends javax.swing.JFrame {

    /**
     * Creates new form CompilerUI
     */
    File currentFile;
    
    public CompilerUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jSplitPane1.setDividerLocation(250);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("lkjhlkjh");
        jScrollPane1.setViewportView(jTextArea1);

        jTabbedPane1.addTab("tab1", jScrollPane1);

        jSplitPane1.setTopComponent(jTabbedPane1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setName("OutputTextArea"); // NOI18N
        jScrollPane2.setViewportView(jTextArea2);

        jSplitPane1.setRightComponent(jScrollPane2);

        jMenu1.setText("File");

        jMenuItem3.setText("New");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Open");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Save As...");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItem6.setText("Undo");
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Redo");
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Run");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Run");
        jCheckBoxMenuItem1.setName("RunMenuItem"); // NOI18N
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed
/*
    *save code:
    if(currentFile != null){
            File existingFile = new File(currentFile.getAbsolutePath());
            System.out.println("overwrite file? "+existingFile != null);
            if(existingFile != null){
                existingFile.delete();
            }

            SaveFile(currentFile.getAbsolutePath());
        }else{
            SaveAs();
        }
    */
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        jTextArea1.setText("if 1==2 do\n    Writeln(5+1);\nelse if 1==1 do\n     Writeln(5+5);\nelse do\n       Writeln(5*5);\nend");
        
    }//GEN-LAST:event_formWindowOpened

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
        jTextArea2.setText(CompilerHelper.compile(jTextArea1.getText(), jTextArea2));
        
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed
    
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //Handle open button action.
        
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Text file", new String[] {"txt"});
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);
        String fileText = "";
        int fileResult = fc.showOpenDialog(this);
        
        if (fileResult == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.

            try {
                FileReader reader = new FileReader(file.getAbsolutePath());
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    fileText += line + "\n";
                }
                reader.close();
                currentFile = file;
                jTextArea1.setText(fileText);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        SaveAs();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    void SaveAs(){
        JFileChooser fc = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Text file", new String[] {"txt"});
        fc.setFileFilter(filter);
        fc.addChoosableFileFilter(filter);
        
        //File existingFile = new File(file.getAbsolutePath());
        //System.out.println("overwrite file? "+existingFile != null);
        if(currentFile != null){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, 
                    "Overwrite current file?","Shortcut",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                currentFile.delete();
                SaveFile(currentFile.getAbsolutePath());
            }else{
                int fileResult = fc.showSaveDialog(this);
                if (fileResult == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    currentFile = file;
                    SaveFile(file.getAbsolutePath());
                }
            }
        }else{
            int fileResult = fc.showSaveDialog(this);
            if (fileResult == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                currentFile = file;
                SaveFile(file.getAbsolutePath());
            }
        }
    }
    void SaveFile(String absolutePath){
        //check if its really a text file
        int lastIndex = absolutePath.length() - 1;
        System.out.println(lastIndex+" chars in path, total string is "+absolutePath);
        String fileWithExt = absolutePath.charAt(lastIndex) == 't' && 
                    absolutePath.charAt(lastIndex - 1) == 'x' && 
                    absolutePath.charAt(lastIndex - 2) == 't' && 
                    absolutePath.charAt(lastIndex - 3) == '.'
                ? absolutePath : absolutePath+".txt";
        System.out.println("last char is "+absolutePath.charAt(lastIndex));
        System.out.println("last char is "+absolutePath.charAt(lastIndex - 1));
        System.out.println("last char is "+absolutePath.charAt(lastIndex - 2));
        System.out.println("last char is "+absolutePath.charAt(lastIndex - 3));
        System.out.println("About to save: "+fileWithExt);
        
        try (
            BufferedReader reader = new BufferedReader(new StringReader(jTextArea1.getText()));
            PrintWriter writer = new PrintWriter(new FileWriter(fileWithExt));
        ) {
            reader.lines().forEach(line -> writer.println(line));
        }catch(Exception e){
            e.printStackTrace();
        }
        /*try {
            FileWriter writer = new FileWriter(fileWithExt, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(jTextArea1.getText());

            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
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
            java.util.logging.Logger.getLogger(CompilerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompilerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompilerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompilerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompilerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
