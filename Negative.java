public class Negative extends Expression {
    Expression expr;
    
    public Negative(Expression n){
        this.expr = n;
    }
    
    public Expression getExpression(){
        return this.expr;
    }
    public void accept(Visitor v){  v.visit(this);
    }
}