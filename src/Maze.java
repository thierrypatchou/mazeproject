import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Maze {

    public Space spaces[];
    public Space[][] maze = null;

    public Maze(){
        spaces = new Space[10000];
    }

    public boolean loadMaze(String filename){
        boolean loaded = true;

        try {
            int ypos = -1;
            int xpos= 0;
            int spaceCount = -1;
            File file = new File(filename);
            Scanner scn = new Scanner(file);
            while (scn.hasNextLine()) {
                ypos++;
                String line = scn.nextLine();
                String[] tokens = line.split(",");
                xpos = 0;
                for(int i = 0; i < tokens.length; i++){
                    spaceCount++;
                    if (tokens[i].equals("X")) {
                        spaces[spaceCount] = new Space(Space.spaceType.closed, spaceCount, ypos, xpos);
                        xpos++;
                    }else if (tokens[i].equals("O")) {
                        spaces[spaceCount] = new Space(Space.spaceType.open, spaceCount, ypos, xpos);
                        xpos++;
                    }else if (tokens[i].equals("S")) {
                        spaces[spaceCount] = new Space(Space.spaceType.start, spaceCount, ypos, xpos);
                        xpos++;
                    }else if (tokens[i].equals("E")) {
                        spaces[spaceCount] = new Space(Space.spaceType.end, spaceCount, ypos, xpos);
                        xpos++;
                    }
                }

            }
             maze = new Space[ypos][xpos];
           int spacesIterator = 0;
            for(int i = 0; i < ypos; i++){
                for(int j = 0; j < xpos; j++){
                    maze[i][j] = spaces[spacesIterator];
                    spacesIterator++;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
            loaded = false;
        }
        return loaded;

    }

    public Space findStartingSpace(Space[] spaces){
            for(int i = 0; i < spaces.length; i++){
                if(spaces[i].getType() == Space.spaceType.start){
                    return spaces[i];
                }
            }
            return null;
    }

    public Space getSpaceFromID(int id){
        for(int i = 0; i<spaces.length; i++){
            if(spaces[i] != null) {
                Space test = spaces[i];
                if (test.getStringId() == (id)) {
                    return spaces[i];
                }
            }
        }
        return null;
    }

    public Space getSpaceFromCoords(int y, int x){
        for(int i = 0; i<spaces.length; i++){
            if(spaces[i] != null) {
                Space test = spaces[i];
                if (test.getyCoord() == y && test.getxCoord() == x) {
                    return spaces[i];
                }
            }
        }
        return null;
    }

    boolean[][] visited = new boolean[maze.length][maze[0].length];
    Stack path = new Stack();

    public boolean Solve(Space sp){

        int x = sp.getxCoord();
        int y = sp.getyCoord();

        if(sp.getType() == Space.spaceType.closed || visited[y][x]){
            return false;
        }
        visited[y][x] = true;
        path.push(sp);

        if(sp.getType() == Space.spaceType.end){
            return true;
        }

        //CHECKS RIGHT
        if(Solve(getSpaceFromCoords(y, x+1))){
            return true;
        }
        //CHECKS UP
        if(Solve(getSpaceFromCoords(y+1, x))){
            return true;
        }
        //CHECKS LEFT
        if(Solve(getSpaceFromCoords(y, x-1))){
            return true;
        }
        //CHECKS DOWN
        if(Solve(getSpaceFromCoords(y-1, x))){
            return true;
        }
        //IF NOTHING WORKS THEN BACKTRACK
        path.pop();
        return false;
    }

}
