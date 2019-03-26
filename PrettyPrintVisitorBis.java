/* public class PrettyPrintVisitorBis extends Visitor<String> {

    public String visit(IfThenElse i){
        return "lol";
    }

    public String visit(Num n) {
        return Integer.toString(n.getValue());
    }
    
    public String visit(Add a) {
        return "ADD(" + a.getOp1().accept(this) + "," + a.getOp2().accept(this) + ")";
    }
    
    public String visit(Sub s) {
        return "SUB(" + s.getOp1().accept(this) + "," + s.getOp2().accept(this) + ")";
    }
    
    public String visit(Mul m) {
        return "MUL(" + m.getOp1().accept(this) + "," + m.getOp2().accept(this) + ")";
    }
    
    public String visit(Div d) {
        return "DIV(" + d.getOp1().accept(this) + "," + d.getOp2().accept(this) + ")";
    }
    
    public String visit(Negative n){
        return "NEGATIVE(" + n.getExpression().accept(this) + ")";
    }
    
    public String visit(Positive p){
        return "POSITIVE(" + p.getExpression().accept(this) + ")";
    }
    
    public String visit(Equal e) {
        return "EQUAL(" + e.getOp1().accept(this) + "," + e.getOp2().accept(this) + ")";
    }
    
    public String visit(NotEqual e) {
        return "NOTEQUAL(" + e.getOp1().accept(this) + "," + e.getOp2().accept(this) + ")";
    }
    
    public String visit(Less l) {
        return "LESS(" + l.getOp1().accept(this) + "," + l.getOp2().accept(this) + ")";
    }
    
    public String visit(GreaterThan g) {
        return "GREATERTHAN(" + g.getOp1().accept(this) + "," + g.getOp2().accept(this) + ")";
    }
    
    public String visit(LessOrEqual l) {
        return "LESSOREQUAL(" + l.getOp1().accept(this) + "," + l.getOp2().accept(this) + ")";
    }
    
    public String visit(GreaterOrEqual g) {
        return "GREATEROREQUAL(" + g.getOp1().accept(this) + "," + g.getOp2().accept(this) + ")";
    }
}*/
