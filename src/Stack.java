public class Stack {

    // Hardcoding a limit of 10,000 might not be the best option
    // May be better to have a constructor that lets you specify the max amount?
    private Space[] stack = new Space[10000];

    // I'd be more clear with the naming here since "nStackPointer" doesn't necessarily mean much until you read push and pop
    // Perhaps something like "currentStackIndex" or something similar that is shorter
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
