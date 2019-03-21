public abstract class VisitorExpression<T>{
    public T visit(Expression e) {
        return e.accept(this);
    }
    
    public abstract T visit(Num n);
    public abstract T visit(Add a);
    public abstract T visit(Sub s);
    public abstract T visit(Mul m);
    public abstract T visit(Div d);
    public abstract T visit(Negative n);
    public abstract T visit(Positive p);
    public abstract T visit(Equal e);
    public abstract T visit(NotEqual n);
    public abstract T visit(LessThan l);
    public abstract T visit(GreaterThan g);
    public abstract T visit(LessOrEqualThan l);
    public abstract T visit(GreaterOrEqualThan g);
}