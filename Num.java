public class Num extends Expression{
    private int value;
    
    public Num(int i){
        this.value = i;
    }
    
    public int getValue(){return this.value;}
    
    public <T> T accept(VisitorExpression<T> v){
        return v.visit(this);
    }
}