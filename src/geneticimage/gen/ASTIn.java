/* Generated By:JJTree: Do not edit this line. ASTIn.java */

package geneticimage.gen;

public class ASTIn extends FnParseNode {
  public ASTIn(int id) {
    super(id);
  }

  public ASTIn(FnParser p, int id) {
    super(p, id);
  }

  public String getType() {
      String s = "";
      for (Token t = firstToken.next; t.next != lastToken; t = t.next)
        s += t.image;
      
      return s;
      //return firstToken.next.image;
  }
  public String getName() {
      Token t = firstToken;
      while(t.next != lastToken)
          t = t.next;
      return t.image;
  
  }
}
