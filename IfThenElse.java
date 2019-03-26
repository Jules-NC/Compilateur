import java.util.ArrayList;

public class IfThenElse extends Statement {
    private Expression condition;
    private ArrayList<Statement> thenList;
    private ArrayList<Statement> elseList;

    public IfThenElse(Expression condition, ArrayList<Statement> thenList, ArrayList<Statement> elseList) {
        this.condition = condition;
        this.thenList = thenList;
        this.elseList = elseList;
    }

    public Expression getCondition() {
        return condition;
    }

    public ArrayList<Statement> getThenList() {
        return thenList;
    }

    public ArrayList<Statement> getElseList() {
        return elseList;
    }

    @Override
    public <T> T accept(Visitor<T> v) {
        return v.visit(this);
    }
}
