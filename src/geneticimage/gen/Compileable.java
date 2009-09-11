// Compileable objects must implement a transform which generates implementation code. 

package geneticimage.gen;

import jd.JavaCodeDescriptor;

public interface Compileable {

    public JavaCodeDescriptor compileToJava() throws CompileException;
}


