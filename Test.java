import static java.lang.System.out;

public abstract class Test
{
   public static void Test() {
       Expression trois = new Num(3);
       Expression deux = new Num(2);
       Expression plus = new Add(trois, deux);
       Expression dix = new Num(10);
       Expression mul = new Mul(plus, dix);
       
       EvaluateVisitor v = new EvaluateVisitor();
       PrettyPrintVisitor pp = new PrettyPrintVisitor();
       
       //System.out.println(mul instanceof Mul);
       
       
       String res2 = pp.visit(mul);
       
       System.out.println(res2 + "\n");
    }
} 
