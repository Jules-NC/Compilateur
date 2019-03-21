public class Equal extends Binary{
    
    public Equal(Expression op1, Expression op2){
        super(op1, op2);
    }
    
    public <T> T accept(VisitorExpression<T> v){
        return v.visit(this);
    }
}
    