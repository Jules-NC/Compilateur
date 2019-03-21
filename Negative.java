public class Negative extends Expression {
    Expression expr;
    
    public Negative(Expression n){
        this.expr = n;
    }
    
    public Expression getExpression(){
        return this.expr;
    }
    
    public <T> T accept(VisitorExpression<T> v){
        return v.visit(this);
    }
}