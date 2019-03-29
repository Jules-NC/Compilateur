public class Add extends Binary{
    public Add(Expression op1, Expression op2){
        super(op1, op2);
    }

    public void accept(Visitor v){  v.visit(this);
    }
}