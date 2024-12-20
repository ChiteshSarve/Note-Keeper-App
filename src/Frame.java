import javax.swing.*;

public class Frame {
    public static JFrame frame;
    public static JTextArea textArea;

    public static void main(String[] args) {
        createFrame();
        createTextArea(); // Call the method to create JTextArea
        createMenu(); // Call the method to create the menu
        frame.setVisible(true);
    }

    public static void createFrame() {
        frame = new JFrame("Note Keeper");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void createTextArea() {
        textArea = new JTextArea();
        JScrollPane scrollbar = new JScrollPane(textArea);
        scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollbar.setBorder(BorderFactory.createEmptyBorder());
        frame.add(scrollbar);
    }

    public static void createMenu() {
        JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);

        JMenu filemenu = new JMenu("File");
        menu.add(filemenu);

        JMenu editmenu = new JMenu("Edit");
        menu.add(editmenu);

        JMenu formatmenu = new JMenu("Format");
        menu.add(formatmenu);

        // Creating the file menu items
        JMenuItem New = new JMenuItem("New");
        New.addActionListener(e -> FileMenu.newFile()); // To link FileMenu Java File
        filemenu.add(New);

        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(e -> FileMenu.openFile());
        filemenu.add(open);

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(e -> FileMenu.save());
        filemenu.add(save);

        JMenuItem saveAs = new JMenuItem("Save As...");
        saveAs.addActionListener(e -> FileMenu.saveAs());
        filemenu.add(saveAs);

        // Creating Edit Menu Items
        JMenuItem cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(e -> Edit.cut());
        editmenu.add(cutItem);

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(e -> Edit.copy());
        editmenu.add(copyItem);

        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(e -> Edit.paste());
        editmenu.add(pasteItem);

        JMenuItem selectItem = new JMenuItem("Select All");
        selectItem.addActionListener(e -> Edit.selectAll());
        editmenu.add(selectItem);

        // Creating Format Menu Items
        JMenuItem boldItem = new JMenuItem("Bold");
        boldItem.addActionListener(e -> FormatMenu.bold());
        formatmenu.add(boldItem);

        JMenuItem italicItem = new JMenuItem("Italic");
        italicItem.addActionListener(e -> FormatMenu.italic());
        formatmenu.add(italicItem);

        JMenuItem fontColorItem = new JMenuItem("Font Color");
        fontColorItem.addActionListener(e -> FormatMenu.fontColor());
        formatmenu.add(fontColorItem);
    }
}
