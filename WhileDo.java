public class WhileDo extends Statement {
    private Expression condition;
    private Statement doStatement;
    //private ArrayList<Statement> elseList;

    public WhileDo(Expression condition, Statement doStatement) {
        this.condition = condition;
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
