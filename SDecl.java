public class SDecl extends Statement{

    private Variable v;
    private Expression e;


    public SDecl(Variable v, Expression e) {
        this.v = v;
        this.e = e;
    }

    public Variable getVariabe() {
        return v;
    }

    public Expression getExpression() {
        return e;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
