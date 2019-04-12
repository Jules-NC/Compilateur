public class For extends Statement {
    private Expression condition;
    private Statement toStatement;
    private Statement doStatement;
    //private ArrayList<Statement> elseList;

    public For(Expression condition, Statement toStatement, Statement doStatement) {
        this.condition = condition;
        this.toStatement = toStatement;
        this.doStatement = doStatement;
    }

    public Expression getCondition() {
        return condition;
    }
    
    public Statement getDoStatement(){
        return this.doStatement;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
