public abstract class Visitor{
    public void visit(Statement t){
        t.accept(this);
    }

    public abstract void visit(IfThenElse i);
    public abstract void visit(Scope s);
    public abstract void visit(SExpression se);
    public abstract void visit(SInit init);
    public abstract void visit(SDecl decl);


    public abstract void visit(Equal e);
    public abstract void visit(NotEqual n);

    public abstract void visit(Less l);
    public abstract void visit(Greater g);
    public abstract void visit(LessOrEqual l);
    public abstract void visit(GreaterOrEqual g);

    public abstract void visit(Add a);
    public abstract void visit(Sub s);

    public abstract void visit(Mul m);
    public abstract void visit(Div d);

    public abstract void visit(Negative n);

    public abstract void visit(Print p);
    public abstract void visit(Variable v);
    public abstract void visit(PString s);
    public abstract void visit(Num n);



}