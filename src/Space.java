public class Space {
    private int stringId;
    private int xCoord;
    private int yCoord;

    public static enum spaceType{start, open,closed, end}

    private spaceType type;

    public Space(spaceType ty, int Id, int y, int x) {
        type = ty;
        stringId = Id;
        xCoord = x;
        yCoord = y;
    }

    public spaceType getType(){
        return type;
    }
    public int getStringId(){
        return stringId;
    }
    public int getxCoord(){
        return xCoord;
    }
    public int getyCoord(){
        return yCoord;
    }


}
