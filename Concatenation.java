public class Concatenation extends Expression{
    
    Expression op1;
    Expression op2;
    
    public Concatenation(Expression op1, Expression op2){
        this.op1 = op1;
        this.op2 = op2;
    }
    
    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}