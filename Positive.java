public class Positive extends Expression {
    Expression expr;
    
    public Positive(Expression n){
        this.expr = n;
    }
    
    public Expression getExpression(){
        return this.expr;
    }
    
    public <T> T accept(VisitorExpression<T> v){
        return v.visit(this);
    }
}