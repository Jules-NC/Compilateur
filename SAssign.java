public class SAssign extends Statement{
    
    private Variable v;
    private Expression e;
    
    public SAssign(Variable v, Expression e){
        this.v = v;
        this.e = e;
    }
    
    public Variable getVariable() {
        return v;
    }

    public Expression getExpression() {
        return e;
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}