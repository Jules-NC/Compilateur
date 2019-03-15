public abstract class VisitorExpression<T>{
    public abstract T visit(Num n);
    public abstract T visit(Add n);
    public abstract T visit(Sub n);
    public abstract T visit(Mul n);
    public abstract T visit(Div n);
    public T visit(Expression e) {
        return e.accept(this);
    }
}