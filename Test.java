import static java.lang.System.out;

public abstract class Test
{
   public static void Test() {
       Expression trois = new Num(3);
       Expression deux = new Num(2);
       Expression plus = new Add(trois, deux);
       Expression dix = new Num(10);
       Expression mul = new Equal(plus, dix);
       
       PrettyPrintVisitor pp = new PrettyPrintVisitor();
       EvaluateVisitor v = new EvaluateVisitor();
       //System.out.println(mul instanceof Mul);
       
       
       Integer res2 = v.visit(mul);
       
       System.out.println(res2 + "\n");
    }
    
   public static void TestCompare() {
       Expression trois = new Num(3);
       Expression deux = new Num(2);
       Expression troisbis = new Num(2);
       
       Expression comphighegal = new GreaterOrEqualThan(trois, trois); // (3>=3) => 1
       Expression complow = new LessThan(comphighegal, deux); 
       
       PrettyPrintVisitor ppv = new PrettyPrintVisitor();
       EvaluateVisitor ev = new EvaluateVisitor();
       
       String res_ppv = ppv.visit(complow);
       Integer res_ev = ev.visit(complow);
       
       System.out.println("Pretty print : " + res_ppv);
       System.out.println("Evaluate : " + res_ev);
   }
} 
