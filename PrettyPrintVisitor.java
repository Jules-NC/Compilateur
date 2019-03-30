import java.util.ArrayList;


public class PrettyPrintVisitor extends Visitor {

    public String STR_VALUE;


    public void visit(Variable v){
        this.STR_VALUE = "VAR(" + v.getName() + ":" + v.getValeur() + ")";
    }

    public void visit(Print p) {
       EvaluateVisitor print = new EvaluateVisitor();
       print.visit(p.getExpression());
       STR_VALUE = "PRINT(" + print.INT_VALUE + ")";
    }


    // <TYPE> <ID> ";"
    public void visit(SDecl decl) {
        String tmp1;
        decl.getVariabe().accept(this);
        tmp1 = this.STR_VALUE;
        this.STR_VALUE = "SDECL(" + tmp1 + ")";
    }

    // <TYPE> <ID> "=" Expr ";"
    public void visit(SInit init) {
        init.getVariabe().accept(this);
        String tmp1 = this.STR_VALUE;
        init.getExpression().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "DECL(" + tmp1 + ", " + tmp2 + ")";
    }

    public void visit(SExpression se){
         se.getExpression().accept(this);
         String tmp = this.STR_VALUE;
         this.STR_VALUE = "STM(" + tmp + ")";
    }

    public void visit(Scope sc){
        String res = "SCOPE{";
        ArrayList<Statement> statements = sc.getStatements();

        for(Statement s : statements){
            s.accept(this);
            res += this.STR_VALUE+ ", ";
        }
        res = res.substring(0, res.length()-2);
        res += "}";
        this.STR_VALUE = res;
    }

    public void visit(IfThenElse i){
        i.getCondition().accept(this);
        String tmp1 = this.STR_VALUE;
        i.getThenStatement().accept(this);
        String tmp2 = this.STR_VALUE;
        i.getElseStatement().accept(this);
        String tmp3 = this.STR_VALUE;
        this.STR_VALUE = "IF[(" + tmp1 + ") THEN(" + tmp2 + ") ELSE(" + tmp3 + ")]";
    }

    public void visit(Num n) {
        this.STR_VALUE = "NUM(" + Integer.toString(n.getValue()) + ")";
    }

    public void visit(PString n) {
        this.STR_VALUE = "STR(" + n.getValue() + ")";
    }

    public void visit(Add a) {
        a.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        a.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "+" + tmp2 + ")";
    }
    
    public void visit(Sub s) {
        s.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        s.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "-" + tmp2 + ")";
    }
    
    public void visit(Mul m) {
        m.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        m.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "*" + tmp2 + ")";
    }
    
    public void visit(Div d) {
        d.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        d.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "/" + tmp2 + ")";
    }
    
    public void visit(Negative n){
        n.getExpression().accept(this);
        String tmp1 = this.STR_VALUE;
        this.STR_VALUE = "NEG(" + tmp1 + ")";
    }
    
    public void visit(Equal e) {
        e.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        e.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "==" + tmp2 + ")";
    }
    
    public void visit(NotEqual e) {
        e.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        e.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "!=" + tmp2 + ")";
    }
    
    public void visit(Less l) {
        l.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        l.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "<" + tmp2 + ")";
    }
    
    public void visit(Greater g) {
        g.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        g.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + ">" + tmp2 + ")";
    }
    
    public void visit(LessOrEqual l) {
        l.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        l.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + "<=" + tmp2 + ")";
    }
    
    public void visit(GreaterOrEqual g) {
        g.getOp1().accept(this);
        String tmp1 = this.STR_VALUE;
        g.getOp2().accept(this);
        String tmp2 = this.STR_VALUE;
        this.STR_VALUE = "(" + tmp1 + ">=" + tmp2 + ")";
    }
}