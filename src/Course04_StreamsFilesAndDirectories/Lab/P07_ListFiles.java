package Course04_StreamsFilesAndDirectories.Lab;

import java.io.File;

public class P07_ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\terra\\Desktop\\SoftUni\\1. Java\\3. Java Advanced Module\\1. Java Advanced\\JavaAdvanced\\src\\Course04_StreamsFilesAndDirectories\\LabResources\\Files-and-Streams");

        if (folder.exists()) {
            //съществува такъв файл
            if (folder.isDirectory()) {
                //файлър е папка
                File[] allFiles = folder.listFiles();
                for (File file : allFiles) {
                    if (!file.isDirectory()) {
                        System.out.printf("%s: [%d]%n", file.getName(), file.length());
                    }
                }
            }
        }
    }
}

