import java.util.ArrayList;

public class EvaluateVisitor extends Visitor{
    public int INT_VALUE = 0;
    public String STR_VALUE = "";

    public Type TYPE;


    public Type getType(){
        return this.TYPE;
    }
    public void visit(SExpression se){
        se.getExpression().accept(this);
    }

    public void visit(Scope se){
        ArrayList<Statement> statements = se.getStatements();
        for(Statement s : statements){
            s.accept(this);
        }
    }

    public void visit(Print p) {
        p.getExpression().accept(this);
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

    public void visit(Num n){
        this.INT_VALUE = n.getValue();
    }

    public void visit(PString o){
        this.STR_VALUE = o.getValue();
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
    
    public void visit(Negative n){
        n.getExpression().accept(this);

        this.INT_VALUE = -INT_VALUE;
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
}