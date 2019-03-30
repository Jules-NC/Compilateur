import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class EvaluateVisitor extends Visitor{
    public int INT_VALUE;
    public String STR_VALUE;
    public Type TYPE;
    public Stack<HashMap<String, Variable>> scopeVars;

    public EvaluateVisitor(){
        this.scopeVars = new Stack<>();
        this.scopeVars.push(new HashMap<>());   // global variables
    }

    public Type getType(){
        return this.TYPE;
    }


    public void visit(IfThenElse i){
        i.getCondition().accept(this);
        int tmp1 = this.INT_VALUE;

        if(tmp1 == 1){
            i.getThenStatement().accept(this);
        } else {
            i.getElseStatement().accept(this);
        }
    }
    public void visit(Scope se){
        ArrayList<Statement> statements = se.getStatements();
        for(Statement s : statements){
            s.accept(this);
        }
    }
    public void visit(SExpression se){
        se.getExpression().accept(this);
    }
    public void visit(SInit init){
        String varName = init.getVariabe().getName();
        init.getExpression().accept(this);
        int tmp1 =this.INT_VALUE;
        init.getVariabe().accept(this);

        init.getVariabe().setValeur(tmp1);
        scopeVars.peek().put(varName, init.getVariabe());

    }
    public void visit(SDecl decl) {
        String varName = decl.getVariabe().getName();
        this.scopeVars.peek().put(varName, decl.getVariabe());
    }


    public void visit(Equal e){
        e.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        e.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        if(tmp1 == tmp2)
            this.INT_VALUE = 1;
        else
            this.INT_VALUE = 0;
    }
    
    public void visit(NotEqual e){
        e.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        e.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        if(tmp1 != tmp2)
            this.INT_VALUE = 1;
        else
            this.INT_VALUE = 0;
    }


    public void visit(Less l){
        l.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        l.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        if(tmp1 < tmp2)
            this.INT_VALUE = 1;
        else
            this.INT_VALUE = 0;
    }
    
    public void visit(Greater g){
        g.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        g.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        if(tmp1 > tmp2)
            this.INT_VALUE = 1;
        else
            this.INT_VALUE = 0;
    }
    
    public void visit(LessOrEqual l){
        l.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        l.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        if(tmp1 <= tmp2)
            this.INT_VALUE = 1;
        else
            this.INT_VALUE = 0;
    }
    
    public void visit(GreaterOrEqual g){
        g.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        g.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        if(tmp1 >= tmp2)
            this.INT_VALUE = 1;
        else
            this.INT_VALUE = 0;
    }


    public void visit(Mul m){
        m.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        m.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        this.INT_VALUE = tmp1 * tmp2;
    }

    public void visit(Div d){
        d.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        d.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        this.INT_VALUE = tmp1 / tmp2;
    }


    public void visit(Add a){
        Type type = a.getType();
        this.TYPE = type;
        if(type==Type.P_Int){
            a.getOp1().accept(this);
            int tmp1 = this.INT_VALUE;
            a.getOp2().accept(this);
            int tmp2 = this.INT_VALUE;

            this.INT_VALUE = tmp1 + tmp2;
        }
        else if(type == Type.P_String){
            a.getOp1().accept(this);
            String tmp1 = this.STR_VALUE;
            a.getOp2().accept(this);
            String tmp2 = this.STR_VALUE;

            this.STR_VALUE = tmp1 + tmp2;
        }
    }

    public void visit(Sub s){
        s.getOp1().accept(this);
        int tmp1 = this.INT_VALUE;
        s.getOp2().accept(this);
        int tmp2 = this.INT_VALUE;

        this.INT_VALUE = tmp1 - tmp2;
    }


    public void visit(Negative n){
        n.getExpression().accept(this);

        this.INT_VALUE = -INT_VALUE;
    }


    public void visit(Print p) {
        p.getExpression().accept(this);
    }


    // TERMINAUX

    public void visit(Variable v){
        HashMap<String, Variable> scope = this.scopeVars.peek();
        Variable xd = new Variable("lol");
        /*xd.setValeur(10);
        scope.put("lol", xd);*/
        String varName = v.getName();

        if(scope.containsKey(varName)){
            this.INT_VALUE = scope.get(varName).getValeur();
            v.setValeur(this.INT_VALUE);
        }
        else{
            scope.put(varName, v);
            this.INT_VALUE = v.getValeur();
        }
    }

    public void visit(Num n){
        this.INT_VALUE = n.getValue();
    }

    public void visit(PString o){
        this.STR_VALUE = o.getValue();
    }
}