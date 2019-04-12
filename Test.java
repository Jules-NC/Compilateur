import java.util.ArrayList;

public abstract class Test{
    public static void test(){
        Expression n1 = new PString("cozcvfddfou");
        Expression n2 = new PString("coucou");
        Expression equal = new Less(n1,n2);
        
        EvaluateVisitor ev = new EvaluateVisitor();
        PrettyPrintVisitor ppv = new PrettyPrintVisitor();
        
        ev.visit(equal);
        ppv.visit(equal);
        
        System.out.println(ppv.STR_VALUE);
        System.out.println(ev.INT_VALUE);
        
    }
        /*
        Variable v = new Variable("lol");
        Expression n = new Num(3);
        Statement si = new SInit(v, n);
        Scope s = new Scope();
        s.addStatement(si);
        
        Expression exp2 = new Variable("lol");
        Statement st2 = new SExpression(exp2);
        s.addStatement(st2);
        
        EvaluateVisitor ev = new EvaluateVisitor();
        PrettyPrintVisitor ppv = new PrettyPrintVisitor();
        
        ev.visit(s);
        ppv.visit(s);
        
        //System.out.println(ppv.STR_VALUE);
        return s;
   }
   
   public static void lol(){
       /*
       Variable v1 = new Variable("lol");
       Expression n1 = new Num(2);
       Statement e1 = new SInit(v1, n1);
       
       Variable v2 = new Variable("lol");
       Statement p1 = new Print(v2);
       
       Expression n2 = new Num(3);
       Statement se1 = new SExpression(n2);
       Scope s1 = new Scope();
       s1.addStatement(se1);
       
       Scope s2 = new Scope();
       s2.addStatement(e1);
       s2.addStatement(p1);
       s2.addStatement(s1);
       
       EvaluateVisitor ev = new EvaluateVisitor();
       ev.visit(s2);
       //System.out.println(ev.STR_VALUE);*/
    
} 
