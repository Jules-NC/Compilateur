public class Print extends Statement{
    
     Expression expr;
    
     public Print(Expression e){
        this.expr = e;
        }
        
    public Expression getExpression(){
        return this.expr;
    }
    
    public void accept(Visitor v){  
        v.visit(this);
    }
}