public class Stack {

    private Space[] stack = new Space[10000];
    private int nStackPointer = 0;

    public void push(Space sp){
        stack[nStackPointer] = sp;
        nStackPointer++;
    }

    public Space pop(){
        if(nStackPointer == 0){
            return null;
        }else{
            return stack[nStackPointer--];
        }
    }
}
