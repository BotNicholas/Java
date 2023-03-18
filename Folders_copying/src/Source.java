import java.io.*;
import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input folder path to copy: ");
        String from = scanner.nextLine();
        File fromFolder = new File(from);

        try {
            if (fromFolder.exists()) {

                System.out.print("Input path where to copy: ");
                String to = scanner.nextLine();

                File toFolder = new File(to + "/" + fromFolder.getName());

                if (fromFolder.isDirectory()) {

                    toFolder.mkdir();
                    copyFolder(fromFolder, toFolder);

                } else
                    System.out.println(from + " is not a directory!!!");
            } else
                System.out.println("Such folder does not exist!");

        } catch(Exception e){
            e.printStackTrace();
        }

    }


//Version I (reading only .txt files)
//    public static void copyFolder(File from, File to) throws IOException {
//        for(File file : from.listFiles()){
//            if(file.isFile()){
//                System.out.println("Copied a file: " + to.getPath() + "/" + file.getName());
//                Files.write(Paths.get(to.getPath() + "/" + file.getName()), Files.readAllLines(Paths.get(file.getPath()))); //creating the same file on new directory
//            } else if(file.isDirectory()){
//                System.out.println("Copied a folder: " + to.getPath() + "/" + file.getName());
//                File folder = new File(to.getPath() + "/" + file.getName()); //creating the same folder on new directory
//                folder.mkdir();
//                //System.out.println("\tWorking on: " + file.getPath() + " | " + folder.getPath());
//                copyFolder(file ,folder);
//            }
//        }



//Version II (reading all files extensions)
    public static void copyFolder(File from, File to) throws IOException {
        for(File file : from.listFiles()){
            if(file.isFile()){

                System.out.println("\t\u001B[32mCopied a file: " + to.getPath() + "\\" + file.getName());

                //Files.write(Paths.get(to.getPath() + "/" + file.getName()), readFile(file.getPath())); //creating the same file on new directory (Old version (copies only .txt files))
                FileOutputStream out = new FileOutputStream(to.getPath() + "/" + file.getName()); // using this way because FileInput/OutputStream reads/writes BYTES. (encoding do not work...)
                out.write(readFile(file.getPath()));

            } else if(file.isDirectory()){
                System.out.println("\t\u001B[32mCopied a folder: " + to.getPath() + "\\" + file.getName());

                File folder = new File(to.getPath() + "/" + file.getName()); //creating the same folder on new directory
                folder.mkdir();

                //System.out.println("\t\t\u001B[32mWorking on: " + file.getPath() + " | " + folder.getPath());

                copyFolder(file ,folder);
            }
        }
    }

//    public static List<String> readFile(String path) throws IOException{
//
//        ArrayList <String> text = new ArrayList<>();
//
//        BufferedReader file = new BufferedReader(new FileReader(path));
//
//        while(file.ready()){
//            String str = file.readLine();
//            System.out.print("\t\t" + str);
//            text.add(str);
//        }
//
//        return text;
//    }

    public static byte[] readFile(String path) throws IOException{

        StringBuilder text = new StringBuilder();

        FileInputStream in = new FileInputStream(path);

        return in.readAllBytes();
    }
}
