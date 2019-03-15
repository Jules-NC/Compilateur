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
    

}