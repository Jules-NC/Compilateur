public class SInit extends Statement{

    private ID v;
    private Expression e;


    public SInit(ID v, Expression e) {
        this.v = v;
        this.e = e;
    }

    public ID getVariabe() {
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
