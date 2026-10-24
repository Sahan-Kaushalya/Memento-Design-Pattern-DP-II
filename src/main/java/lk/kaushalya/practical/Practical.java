package lk.kaushalya.practical;

import java.util.Stack;

// originator
class File{
    private String fileName;
    private String fileContent;
    private String fileType;

    public File(String fileName, String fileContent, String fileType) {
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void displayFileDetails() {
        System.out.println();
        System.out.println("File Name: " + fileName);
        System.out.println("File Content: " + fileContent);
        System.out.println("File Type: " + fileType);
        System.out.println("-----------------------------------");
    }
}

// memento
final class FileMemento{

    private String fileName;
    private String fileContent;

    public FileMemento(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContent() {
        return fileContent;
    }
}

// caretaker
class FileCaretaker{
    private Stack<FileMemento> mementoStack = new Stack<>();

    public void save(File file) {
        mementoStack.push(new FileMemento(file.getFileName(), file.getFileContent()));
        System.out.println("File saved successfully!");
    }

    public  void load(File file){
        FileMemento memento = mementoStack.pop();
        file.setFileName(memento.getFileName());
        file.setFileContent(memento.getFileContent());
        System.out.println("File loaded successfully!");
    }
}
public class Practical {
    public static void main(String[] args) {
        File file = new File("MyFile.txt", "This is the content of the file.", "txt");
        FileCaretaker caretaker = new FileCaretaker();

        file.displayFileDetails();

        // Save the current state of the file
        caretaker.save(file);

        // Modify the file
        file.setFileName("ModifyFile.txt");
        file.setFileContent("Modify the file content.");
        file.displayFileDetails();

        // Load the previous state of the file
        caretaker.load(file);
        file.displayFileDetails();
    }
}
