import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

    public Space[] spaces = new Space[10000];

    public boolean loadMaze(String filename){
        boolean loaded = true;

        try {
            File file = new File(filename);
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                String[] tokens = line.split(",");
                for(int i = 0; i < tokens.length; i++){
                    if (tokens[i].equals("X")) {
                        new Space(closed, i, 0, 3);
                    }else if (tokens[i].equals("0")) {

                    }else if (tokens[i].equals("S")) {

                    }else if (tokens[i].equals("E")) {

                    }
                }

            }
        }catch(IOException e){
            e.printStackTrace();
            loaded = false;
        }
        return loaded;

    }
}