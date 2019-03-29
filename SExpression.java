public class SExpression extends Statement{
    private Expression expression;

    public SExpression(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor v){  v.visit(this);
    }
}
