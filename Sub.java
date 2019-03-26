public class Sub extends Binary{
    public Sub(Expression op1, Expression op2){
        super(op1, op2);
    }

    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}