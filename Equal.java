public class Equal extends Binary{
    
    public Equal(Expression op1, Expression op2){
        super(op1, op2);
    }
    
    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}
    