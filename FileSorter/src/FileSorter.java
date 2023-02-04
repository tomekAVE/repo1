import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

public class FileSorter {
        public static void main(String[] args) {

            File file = new File("C:\\Users\\Tomek\\Desktop");
            String sourceDirectory = "C:\\Users\\Tomek\\Desktop\\";
            String destinationDirectory = "C:\\Users\\Tomek\\Desktop\\Pdf\\";
            String[] pdfs = file.list(new FilenameFilter() {

                @Override
                public boolean accept(File dir, String name) {
                    if (name.toLowerCase().endsWith(".pdf")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            });

            ArrayList<Path> sourcePaths = new ArrayList<>();
            ArrayList<Path> destinationPaths = new ArrayList<>();


            for(String element : pdfs){ // for every file in pdfs (from desktop)\
                System.out.println(element);
                sourcePaths.add(Paths.get(sourceDirectory ,element)); // adding to the list of sourcePaths
                //Paths.get creates path from the string parameters
                destinationPaths.add(Paths.get(destinationDirectory, element)); // we create lists of source paths and destination paths
            }

            ArrayList<Path> copy = new ArrayList<>(sourcePaths);

            for(int i = 0; i < sourcePaths.size(); i++){

                try {
                    Files.move(sourcePaths.get(i), destinationPaths.get(i), ATOMIC_MOVE); // Files.move(source path, destination path, CopyOption)
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

