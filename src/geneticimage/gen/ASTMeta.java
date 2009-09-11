/* Generated By:JJTree: Do not edit this line. ASTMeta.java */

package geneticimage.gen;
import java.util.*;

public class ASTMeta extends FnParseNode {
    public ASTMeta(int id) {
        super(id);
    }

    public ASTMeta(FnParser p, int id) {
        super(p, id);
    }

    List<String> metaNames = new ArrayList();
    List<String> metaValues = new ArrayList();
    
    public void addMeta(String name, ASTFnExpression value) {
        metaNames.add(name);
        metaValues.add(value.dumpTokens());
    }
    
    public int getNumber() {return metaNames.size();}
    public String getName(int i) {return metaNames.get(i);}
    public String getValue(int i) {return metaValues.get(i);}
}
