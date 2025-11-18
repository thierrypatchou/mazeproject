import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

    // TLinn - It might possibly be better to have spaces be PRIVATE rather than PUBLIC
    // Having it public isn't necessarily safe since anyone can edit and change it.
    public Space[] spaces = new Space[10000];

    public boolean loadMaze(String filename){

        /* TLinn - We may need a discussion on what the implications of "being loaded" is, for instance, we consider
           a maze is loaded as long as this function was able to open the file. If the maze for instance, was empty,
           Do we still consider it loaded? The current design isn't necessarily wrong but I think such nuances should be 
           Noted in the function documentation to make it clear that there is potential for an empty maze being successfully loaded
        */
        boolean loaded = true;

        try {
            File file = new File(filename);
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                String[] tokens = line.split(",");

                /* TLinn - While the project samples use a limited list of characters to represent the "tiles" in a maze, 
                   I believe you should have them specified somewhere else that is more cleanly editible than hardcoding them here
                */
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
