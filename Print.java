public class Print extends Expression{
    
     Expression expr;
    
     public Print(Expression e){
        this.expr = e;
        }
    public Expression getExpression(){
        return this.expr;
    }
    
    public <T> T accept(Visitor<T> v){
        return v.visit(this);
    }
}