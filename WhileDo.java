import java.util.ArrayList;

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
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
