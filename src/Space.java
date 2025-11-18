public class Space {
    private int stringId;
    private int xCoord;
    private int yCoord;

    public static enum spaceType{start, open, closed, end}

    private spaceType type;

    public Space(spaceType ty, int Id, int x, int y) {
        type = ty;
        stringId = Id;
        xCoord = x;
        yCoord = y;
    }

    public spaceType getType(){
        return type;
    }
}
