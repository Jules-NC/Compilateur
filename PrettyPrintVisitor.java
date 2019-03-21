public class PrettyPrintVisitor extends VisitorExpression<String>{
    public String visit(Num n) {
        return new Integer(n.getValue()).toString();
    }
    
    public String visit(Add a) {
        return "(" + a.getOp1().accept(this) + "+" + a.getOp2().accept(this) + ")";
    }
    
    public String visit(Sub s) {
        return "(" + s.getOp1().accept(this) + "-" + s.getOp2().accept(this) + ")";
    }
    
    public String visit(Mul m) {
        return "(" + m.getOp1().accept(this) + "*" + m.getOp2().accept(this) + ")";
    }
    
    public String visit(Div d) {
        return "(" + d.getOp1().accept(this) + "/" + d.getOp2().accept(this) + ")";
    }
    
    public String visit(Negative n){
        return "-" + "(" + n.getExpression().accept(this) + ")";
    }
    
    public String visit(Positive p){
        return p.getExpression().accept(this);
    }
    
    public String visit(Equal e) {
        return "(" + e.getOp1().accept(this) + "=" + e.getOp2().accept(this) + ")";
    }
    
    public String visit(NotEqual e) {
        return "(" + e.getOp1().accept(this) + "<>" + e.getOp2().accept(this) + ")";
    }
    
    public String visit(LessThan l) {
        return "(" + l.getOp1().accept(this) + "<" + l.getOp2().accept(this) + ")";
    }
    
    public String visit(GreaterThan g) {
        return "(" + g.getOp1().accept(this) + ">" + g.getOp2().accept(this) + ")";
    }
    
    public String visit(LessOrEqualThan l) {
        return "(" + l.getOp1().accept(this) + "<=" + l.getOp2().accept(this) + ")";
    }
    
    public String visit(GreaterOrEqualThan g) {
        return "(" + g.getOp1().accept(this) + "=>" + g.getOp2().accept(this) + ")";
    }
}