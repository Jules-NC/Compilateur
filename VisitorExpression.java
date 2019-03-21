public abstract class VisitorExpression<T>{
    public T visit(Expression e) {
        return e.accept(this);
    }
    public abstract T visit(Num n);
    public abstract T visit(Add n);
    public abstract T visit(Sub n);
    public abstract T visit(Mul n);
    public abstract T visit(Div n);
    public abstract T visit(Negative e);
    public abstract T visit(Positive e);
}