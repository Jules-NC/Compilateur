public class Num extends Expression{
    private int value;
    
    public Num(int i){
        this.type = Type.P_Int;
        this.value = i;
    }
    
    public int getValue(){return this.value;}

    public void accept(Visitor v){  v.visit(this);
    }
}