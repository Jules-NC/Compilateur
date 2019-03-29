import java.util.ArrayList;

public class Scope extends Statement{

    private ArrayList<Statement> statements;

    public Scope() {
        this.statements = new ArrayList<>();
    }

    public void addStatement(Statement a){
        statements.add(a);
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}