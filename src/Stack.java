public class Stack {

    public Stack() {

    }
    public Space[] stack = new Space[10000];
    private int currentStackIndex = 0;

    public void push(Space sp){
        stack[currentStackIndex] = sp;
        currentStackIndex++;
    }

    public Space pop(){
        if(currentStackIndex == 0){
            return null;
        }else{
            return stack[currentStackIndex--];
        }
    }
}
