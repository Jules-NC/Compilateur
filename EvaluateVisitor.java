public class EvaluateVisitor extends Visitor<Integer> {

    public Integer visit(IfThenElse i){
        return 1;
    }

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
    
    public Integer visit(Negative n){
        return -1*n.getExpression().accept(this);
    }
    
    public Integer visit(Positive n){
        return n.getExpression().accept(this);
    }
    
    public Integer visit(Equal e){
        if(e.getOp1().accept(this) == e.getOp2().accept(this)){
            return 1;
        } else {
            return 0;
        }
    }
    
    public Integer visit(NotEqual e){
        if(e.getOp1().accept(this) != e.getOp2().accept(this)){
            return 1;
        } else {
            return 0;
        }
    }
    
    public Integer visit(Less l){
        if(l.getOp1().accept(this) < l.getOp2().accept(this)){
            return 1;
        } else {
            return 0;
        }
    }
    
    public Integer visit(Greater g){
        if(g.getOp1().accept(this) > g.getOp2().accept(this)){
            return 1;
        } else {
            return 0;
        }
    }
    
    public Integer visit(LessOrEqual l){
        if(l.getOp1().accept(this) <= l.getOp2().accept(this)){
            return 1;
        } else {
            return 0;
        }
    }
    
    public Integer visit(GreaterOrEqual g){
        if(g.getOp1().accept(this) >= g.getOp2().accept(this)){
            return 1;
        } else {
            return 0;
        }
    }
}