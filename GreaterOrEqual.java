public class GreaterOrEqual extends Binary{
    
    public GreaterOrEqual(Expression op1, Expression op2){
        super(op1, op2);
    }
    public void accept(Visitor v){
        v.visit(this);
    }
}
    