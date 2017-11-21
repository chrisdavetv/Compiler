/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compile.compiler;

import compile.compilersource.CompilerHelper;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

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

    public javax.swing.JTextArea getEditor(){
        return this.jTextArea1;
    }
    
    public javax.swing.JTextArea getOutputConsole(){
        return this.jTextArea2;
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
        jMenu3 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

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

        LineNumberedBorder lnb = new LineNumberedBorder(LineNumberedBorder.LEFT_SIDE, LineNumberedBorder.LEFT_JUSTIFY);
        jTextArea1.setBorder(lnb);

        final UndoManager undo = new UndoManager();
        Document doc = jTextArea1.getDocument();

        // Listen for undo and redo events
        doc.addUndoableEditListener(new UndoableEditListener() {
            public void undoableEditHappened(UndoableEditEvent evt) {
                undo.addEdit(evt.getEdit());
            }
        });

        // Create an undo action and add it to the text component
        jTextArea1.getActionMap().put("Undo",
            new AbstractAction("Undo") {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        if (undo.canUndo()) {
                            undo.undo();
                        }
                    } catch (CannotUndoException e) {
                    }
                }
            });

            // Bind the undo action to ctl-Z
            jTextArea1.getInputMap().put(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()), "Undo");

            // Create an undo action and add it to the text component
            jTextArea1.getActionMap().put("Redo",
                new AbstractAction("Redo") {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            if (undo.canRedo()) {
                                undo.redo();
                            }
                        } catch (CannotUndoException e) {
                        }
                    }
                });

                // Bind the undo action to ctl-Z
                jTextArea1.getInputMap().put(KeyStroke.getKeyStroke('Y', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()), "Redo");
                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);
                jTextArea1.setText("lkjhlkjh");
                jScrollPane1.setViewportView(jTextArea1);

                jTabbedPane1.addTab("tab1", jScrollPane1);

                jSplitPane1.setTopComponent(jTabbedPane1);

                jTextArea2.setColumns(20);
                jTextArea2.setRows(5);
                jTextArea2.setName("OutputTextArea");
                jTextArea2.addMouseListener(new MouseAdapter()
                    {
                        public void mouseClicked(MouseEvent me)
                        {
                            String s = "";
                            String[] splitS = new String[5];
                            if (!jTextArea2.getText().trim().equals("")) {
                                int position = jTextArea2.viewToModel(jTextArea2.getMousePosition());
                                String[] text = jTextArea2.getText().split("\n");
                                int[] charNum = new int[text.length];
                                for (int i = 0; i < text.length; i++) {
                                    charNum[i] = text[i].length() + 1;
                                }
                                int sum = 0;
                                for (int i = 0; i < charNum.length; i++) {
                                    sum += charNum[i];
                                    if (sum >= position) {
                                        s += text[i] + "\n";
                                        break;
                                    }
                                }
                                //System.out.println("Clicked on text: " + s);
                                Pattern pattern = Pattern.compile("line \\d+");
                                Matcher matcher = pattern.matcher(s);
                                if (matcher.find())
                                {
                                    try{
                                        String lineStr = matcher.group(0);
                                        System.out.println(lineStr);
                                        lineStr = lineStr.split(" ")[1];
                                        System.out.println("Error line number is: " + lineStr);
                                        int pos = Integer.parseInt(lineStr) * jTextArea1.getColumns();

                                        //go to error line number in editor
                                        // Get the rectangle of the where the text would be visible...
                                        Rectangle viewRect = jTextArea1.modelToView(pos);
                                        // Scroll to make the rectangle visible
                                        jTextArea1.scrollRectToVisible(viewRect);
                                        // Highlight the text
                                        jTextArea1.setCaretPosition(pos);
                                        jTextArea1.moveCaretPosition(pos);
                                    }catch(Exception ne){
                                        System.out.println("Error: " +  ne.getMessage());
                                    }
                                }

                            }
                        }
                    });
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

                    Action cut = new DefaultEditorKit.CutAction();
                    Action paste = new DefaultEditorKit.PasteAction();
                    Action copy = new DefaultEditorKit.CopyAction();
                    //UndoManager manager = new UndoManager();
                    //Action undo = javax.swing.undo.UndoManagerHelper.getUndoAction(manager);
                    //Action redo = javax.swing.undo.UndoManagerHelper.getRedoAction(manager);

                    Action[] textActions = { cut, copy, paste };
                    for (Action textAction : textActions) {
                        javax.swing.JMenuItem menuitem = new javax.swing.JMenuItem(textAction);

                        if(textAction == cut ){
                            menuitem.setText("Cut");
                            menuitem.setAccelerator(KeyStroke.getKeyStroke('X', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
                        } else if(textAction == copy ){
                            menuitem.setText("Copy");
                            menuitem.setAccelerator(KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
                        } else if(textAction == paste ){
                            menuitem.setText("Paste");
                            menuitem.setAccelerator(KeyStroke.getKeyStroke('V', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
                        } /*else if (textAction == undo){
                            menuitem.setText("Undo");
                            menuitem.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
                        } else if (textAction == redo){
                            menuitem.setText("Redo");
                            menuitem.setAccelerator(KeyStroke.getKeyStroke('Y', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
                        }*/
                        jMenu2.add(menuitem);
                    }
                    jMenu2.setText("Edit");
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

                    jMenu4.setText("Search");
                    jMenu4.setName("SearchMenu"); // NOI18N

                    jMenuItem2.setText("Search Code");
                    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jMenuItem2ActionPerformed(evt);
                        }
                    });
                    jMenu4.add(jMenuItem2);

                    jMenuBar1.add(jMenu4);

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
        String testcode = "//This sample code (also in compilerdemofinal.txt)  tests my script - like grammar for  math operators, comparison operators,\n" +
                            "// type agnostic variable declaration,  if-then-else, for and while loops, ternary conditional expressions, assignment,\n" +
                            "// parenthesis grouped expression evaluation, function calls\n" +
                            "\n" +
                            "def useTernary\n" +
                            "useTernary = false	 //change this to test ternary expresson or traditional if-then type conditional\n" +
                            "\n" +
                            "def demonstarteMathOps()	\n" +
                            "	//comments are supported as well\n" +
                            "	\n" +
                            "	Writeln(\"Starting math ops demonstration\")\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "	def x, y\n" +
                            "	x = 10\n" +
                            "	y = 50\n" +
                            "\n" +
                            "	//addition\n" +
                            "	Write(\"Adding 10 and 50: \")\n" +
                            "	Writeln(x+y)\n" +
                            "	\n" +
                            "	//sub\n" +
                            "	Write(\"Subtracting 10 and 50: \")\n" +
                            "	Writeln(x - y)\n" +
                            "\n" +
                            "	//mult\n" +
                            "	Write(\"Multiplying 10 and 50:\")\n" +
                            "	Writeln(x * y)\n" +
                            "\n" +
                            "	//div\n" +
                            "	Write(\"Dividing 10 and 50:\")\n" +
                            "	Writeln(10/50)\n" +
                            "\n" +
                            "	//exponentiation\n" +
                            "	Write(\"Raising 10 to the 50th power:\")\n" +
                            "	Writeln(10^50)\n" +
                            "\n" +
                            "	//modulo\n" +
                            "	Write(\"10 modulo 50:\")\n" +
                            "	Writeln(10%50)\n" +
                            "	Writeln()Writeln()Writeln()\n" +
                            "end\n" +
                            "\n" +
                            "def demonstrateComparisonOps()\n" +
                            "	def a,b, c, compareResult\n" +
                            "	a = 100\n" +
                            "	b = 200\n" +
                            "	c = 300\n" +
                            "	Write(\"Starting comparison operators demo: Creating 3 variables a, b and c with respective values: \")\n" +
                            "	Write(a)\n" +
                            "	Write(\", \")\n" +
                            "	Write(b)\n" +
                            "	Write(\", \")\n" +
                            "	Writeln(c)\n" +
                            "	Write(\" and using boolean variables to hold comparison result\")\n" +
                            "	Writeln()\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "	// equals, not equal\n" +
                            "	Write(\"Is a equal to b?: \")\n" +
                            "	compareResult = a ==b\n" +
                            "	Writeln(compareResult)\n" +
                            "	Write(\"Is a not equal to b+1?: \")\n" +
                            "	compareResult = a != ( b + 1) \n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "	//lessthan\n" +
                            "	Write(\"Is a less than b?:\")\n" +
                            "	compareResult = a < b\n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()	\n" +
                            "\n" +
                            "	//lessthanequal\n" +
                            "	Write(\"Is a - 1 less than or equal to b?: \")\n" +
                            "	compareResult = (a-1) <= b\n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "	//greaterthan\n" +
                            "	Write(\"Is b greater than a?: \")\n" +
                            "	compareResult = b > a\n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "	//greaterthan equal\n" +
                            "	Write(\"Is a >= a? :\")\n" +
                            "	compareResult = a >= a\n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()\n" +
                            "	\n" +
                            "	//And\n" +
                            "	Write(\"Is a < 2 AND b > 4? : \")\n" +
                            "	compareResult = a < 2 && b > 4\n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "	//OR\n" +
                            "	Write(\"Is a < 2 OR b > 4? : \")\n" +
                            "	compareResult = a < 2 || b > 4\n" +
                            "	Writeln(compareResult)\n" +
                            "	Writeln()\n" +
                            "\n" +
                            "end\n" +
                            "\n" +
                            "def printTernarySuccessBranch()\n" +
                            "	Writeln(\"Ternary Success branch executed!\")\n" +
                            "end\n" +
                            "def printTernaryFalseBranch()\n" +
                            "	Writeln(\"Ternary False branch executed!\")\n" +
                            "end\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "//main code is simply all code that is not wrapped in a function, like the following\n" +
                            "if(useTernary) do\n" +
                            "\n" +
                            "	(1 == 1) ? printTernarySuccessBranch() : printTernaryFalseBranch() \n" +
                            "\n" +
                            "else do \n" +
                            "\n" +
                            "	if 1==2 do\n" +
                            "   	 	Writeln(\"first condition met\")\n" +
                            "	else if 1==1 do\n" +
                            "     		Writeln(\"Starting compiler demo: Please note that all numbers used in math/comparison operations are stored in variables. Included with this jar file are sample grammar source code files to verify functionality.\")\n" +
                            "		demonstarteMathOps()\n" +
                            "		demonstrateComparisonOps()\n" +
                            "	else do\n" +
                            "      		 Writeln(\"else if condition met\")\n" +
                            "	end\n" +
                            "\n" +
                            "end";
        jTextArea1.setText(testcode);
        
    }//GEN-LAST:event_formWindowOpened

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
    	jTextArea2.setText("");
        jTextArea1.getHighlighter().removeAllHighlights();
        jTextArea2.append(CompilerHelper.compile(jTextArea1.getText(), CompilerUI.this));
        
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

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        // call search functionality here
    }//GEN-LAST:event_jMenuItem2ActionPerformed
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
    
    public void SearchEditorForTextThenScrollIfFound(javax.swing.JTextArea textArea, String text){
        int pos = 0;
        
        String find = text.toLowerCase();
        // Focus the text area, otherwise the highlighting won't show up
        textArea.requestFocusInWindow();
        // Make sure we have a valid search term
        if (find != null && find.length() > 0) {
            Document document = textArea.getDocument();
            int findLength = find.length();
            try {
                boolean found = false;
                // Rest the search position if we're at the end of the document
                if (pos + findLength > document.getLength()) {
                    pos = 0;
                }
                // While we haven't reached the end...
                // "<=" Correction
                while (pos + findLength <= document.getLength()) {
                    // Extract the text from teh docuemnt
                    String match = document.getText(pos, findLength).toLowerCase();
                    // Check to see if it matches or request
                    if (match.equals(find)) {
                        found = true;
                        break;
                    }
                    pos++;
                }

                // Did we find something...
                if (found) {
                    // Get the rectangle of the where the text would be visible...
                    Rectangle viewRect = textArea.modelToView(pos);
                    // Scroll to make the rectangle visible
                    textArea.scrollRectToVisible(viewRect);
                    // Highlight the text
                    textArea.setCaretPosition(pos + findLength);
                    textArea.moveCaretPosition(pos);
                    // Move the search position beyond the current match
                    pos += findLength;
                }

            } catch (Exception exp) {
                exp.printStackTrace();
            }

        }
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
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
