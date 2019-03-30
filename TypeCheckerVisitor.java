public class TypeCheckerVisitor extends Visitor{

    public Type TYPE;


    public void visit(Scope o){
        this.TYPE = Type.P_Void;
        for(Statement s: o.getStatements())
            s.accept(this);
    }

    public void visit(SExpression o){
        this.TYPE = Type.P_Void;
        o.getExpression().accept(this);
    }


    // TYPE ID ";"
    public void visit(SDecl decl) {
        decl.getVariabe().accept(this);
    }

    // TYPE ID "=" Expr ";"
    public void visit(SInit decl) {
        decl.getVariabe().accept(this);
        Type t1 = this.TYPE;
        decl.getExpression().accept(this);
        Type t2 = this.TYPE;

        if(t1==t2){

        }
        else{
            throw new RuntimeException("Invalid Type");
        }

    }

    public void visit(Variable v){
        this.TYPE = Type.P_Int;
    }

    public void visit(Print var1){
        this.TYPE = Type.P_Void;
        var1.getExpression().accept(this);
    }

    public void visit(IfThenElse o){
        this.TYPE = Type.P_Void;
        o.getCondition().accept(this);
        o.getThenStatement().accept(this);
        o.getElseStatement().accept(this);
    }

    public void visit(PString o){
        this.TYPE = Type.P_String;
    }

    public void visit(Num n){
        TYPE = Type.P_Int;
    }

    public void visit(Add a){
        a.getOp1().accept(this);
        Type t1 = this.TYPE;
        a.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            a.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Sub a){
        a.getOp1().accept(this);
        Type t1 = this.TYPE;
        a.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            a.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }
    
    
    public void visit(Mul m){
        m.getOp1().accept(this);
        Type t1 = this.TYPE;
        m.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            m.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }
    public void visit(Div d){
        d.getOp1().accept(this);
        Type t1 = this.TYPE;
        d.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            d.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Negative n){
        n.getExpression().accept(this);
        Type t1 = this.TYPE;

        if(t1 != Type.P_String){
            n.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Equal e){
        e.getOp1().accept(this);
        Type t1 = this.TYPE;
        e.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            e.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(NotEqual n){
        n.getOp1().accept(this);
        Type t1 = this.TYPE;
        n.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            n.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Less l){
        l.getOp1().accept(this);
        Type t1 = this.TYPE;
        l.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            l.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(Greater g){
        g.getOp1().accept(this);
        Type t1 = this.TYPE;
        g.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            g.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(LessOrEqual l){
        l.getOp1().accept(this);
        Type t1 = this.TYPE;
        l.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            l.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }

    public void visit(GreaterOrEqual g){
        g.getOp1().accept(this);
        Type t1 = this.TYPE;
        g.getOp2().accept(this);
        Type t2 = this.TYPE;

        if(t1 == t2){
            g.setType(TYPE);
        }
        else {
            throw new RuntimeException("Incorrect Types");
        }
    }
}
