public abstract class Visitor<T>{
    public T visit(Statement t){
        return t.accept(this);
    }

    public abstract T visit(SReturn b);
    public abstract T visit(IfThenElse i);
    public abstract T visit(Num n);
    public abstract T visit(Add a);
    public abstract T visit(Sub s);
    public abstract T visit(Mul m);
    public abstract T visit(Div d);
    public abstract T visit(Negative n);
    public abstract T visit(Positive p);
    public abstract T visit(Equal e);
    public abstract T visit(NotEqual n);
    public abstract T visit(Less l);
    public abstract T visit(Greater g);
    public abstract T visit(LessOrEqual l);
    public abstract T visit(GreaterOrEqual g);
}