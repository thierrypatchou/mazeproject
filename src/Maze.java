import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

    public Space[] spaces = new Space[10000];
    Space maze[][] = new Space[ypos][xpos];

    public boolean loadMaze(String filename){
        boolean loaded = true;

        try {
            int ypos = -1;
            int xpos= 0;
            File file = new File(filename);
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                ypos++;
                String line = scn.nextLine();
                String[] tokens = line.split(",");
                xpos = 0;
                for(int i = 0; i < tokens.length; i++){
                    if (tokens[i].equals("X")) {
                        new Space(Space.spaceType.closed, i, ypos, xpos);
                        xpos++;
                    }else if (tokens[i].equals("0")) {
                        new Space(Space.spaceType.open, i, ypos, xpos);
                        xpos++;
                    }else if (tokens[i].equals("S")) {
                        new Space(Space.spaceType.start, i, ypos, xpos);
                        xpos++;
                    }else if (tokens[i].equals("E")) {
                        new Space(Space.spaceType.end, i, ypos, xpos);
                        xpos++;
                    }
                }

            }
            Space maze[][] = new Space[ypos][xpos];
            for(int i = 0; i < ypos; i++){
                for(int j = 0; j < xpos; j++){

                }
            }
        }catch(IOException e){
            e.printStackTrace();
            loaded = false;
        }
        return loaded;

    }

}