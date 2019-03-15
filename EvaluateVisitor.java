public class EvaluateVisitor extends VisitorExpression<Integer>{
    public Integer visit(Num n){
        return n.getValue();
    }
    
    public Integer visit(Add a){
        return a.getOp1().accept(this) + a.getOp2().accept(this);
    }
    
    public Integer visit(Sub s){
        return s.getOp1().accept(this) - s.getOp2().accept(this);
    }
    
    public Integer visit(Mul m){
        return m.getOp1().accept(this) * m.getOp2().accept(this);
    }
    
    public Integer visit(Div d){
        return d.getOp1().accept(this) / d.getOp2().accept(this);
    }
}