public class IfThenElse extends Statement {
    private Expression condition;
    private Statement thenStatement;
    private Statement elseStatement;
    //private ArrayList<Statement> elseList;

    public IfThenElse(Expression condition, Statement thenStatement, Statement elseStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
        this.elseStatement = elseStatement;
    }

    public Expression getCondition() {
        return condition;
    }
    
    public Statement getThenStatement(){
        return this.thenStatement;
    }
    
    public Statement getElseStatement(){
        return this.elseStatement;
    }

    @Override
    public void accept(Visitor v){  v.visit(this);
    }
}
