import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;

public class EvaluateVisitor extends Visitor{
    public int INT_VALUE;
    public String STR_VALUE;
    public Type TYPE;
    public LinkedList<HashMap<String, Variable>> scopeVars;

    public EvaluateVisitor(){
        this.STR_VALUE = "";
        this.scopeVars = new LinkedList<>();
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

    public void visit(WhileDo w){
        w.getCondition().accept(this);
        int tmp1 = this.INT_VALUE;
        String res = "";

        while(tmp1 == 1){
            w.getDoStatement().accept(this);
            res += this.STR_VALUE + "\n";
            w.getCondition().accept(this);
            tmp1 = this.INT_VALUE;
        }
        //res = res.substring(0, res.length()-1);
        this.STR_VALUE = res;
    }

    public void visit(Scope se){ 
        this.STR_VALUE = "";
        this.scopeVars.push(new HashMap<>());
        ArrayList<Statement> statements = se.getStatements();
        String res = "";
        for(Statement s : statements){
            s.accept(this);
            res += this.STR_VALUE;
        }
        //res = res.substring(0, res.length()-1);
        this.scopeVars.pop();
        this.STR_VALUE = res;
    }

    public void visit(SExpression se){
        se.getExpression().accept(this);
    }

    public void visit(SInit init){
        String varName = init.getVariabe().getName();
        init.getExpression().accept(this);
        int tmp1 =this.INT_VALUE;
        init.getVariabe().accept(this);

        Variable v = new Variable(varName);
        v.setValeur(tmp1);
        scopeVars.peek().put(varName, v);
        init.getVariabe().setValeur(tmp1);
    }

    public void visit(SDecl decl) {
        String varName = decl.getVariabe().getName();
        Variable v = new Variable(varName);
        v.setValeur(this.scopeVars.peek().get(varName).getValeur());
        this.scopeVars.peek().put(varName, v);
    }

    public void visit(SAssign a) {
        String str = a.getVariable().getName();
        a.getVariable().accept(this);
        int tmp1 = this.INT_VALUE;
        a.getExpression().accept(this);

        for(HashMap<String, Variable> hm : this.scopeVars){
            if(hm.containsKey(str)){
                Variable v = hm.get(str);
                v.setValeur(this.INT_VALUE);
                break;
            }
        }
        this.STR_VALUE = "";
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
        if(this.TYPE == Type.P_Int)
            this.STR_VALUE = "" + this.INT_VALUE + "\n";
        else
            this.STR_VALUE = "" + this.STR_VALUE + "\n";
    }

    // TERMINAUX
    public void visit(Variable v){
        String varName = v.getName();
        boolean flag = false;
        for(HashMap<String, Variable> hm : this.scopeVars){
            if(hm.containsKey(varName)){
                this.INT_VALUE = hm.get(varName).getValeur();
                v.setValeur(this.INT_VALUE);
                flag = true;
                break;
            }
        }
    }

    public void visit(ID id){
        String varName = id.getName();
        for(HashMap<String, Variable> hm : this.scopeVars){
            if(hm.containsKey(varName)){
                this.INT_VALUE = hm.get(varName).getValeur();
                id.setValeur(this.INT_VALUE);
                break;
            }
        }
    }

    public void visit(Num n){
        this.INT_VALUE = n.getValue();
    }

    public void visit(PString o){
        this.STR_VALUE = o.getValue();
    }
}