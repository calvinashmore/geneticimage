// Parse node for the beat top level 

package geneticimage.gen;

import java.util.*;
import java.io.*;
import java.security.*;
import java.lang.reflect.*;
import jd.*;
//import macro.*;

// fixme: for now I'm not including the machinery for variable definitions (scope maintainence). 
// If I want to add this, extend BeatScopeMaintainer.
public class ASTFnTopLevel extends FnParseNode implements Compileable {

    // name of the package within which the beat(s) should be defined
    //String fnPackage = null;
    String fnPackage = "gen.functions";
    String fnDirectory = "src/gen/functions";
    String fnGroup = null;

    // Names of import packages. 
    private final static String[] importPackages = {
        "utils.*",
        "utils.estimates.*",
        "utils.linear.*",
        "utils.linear.grid.*",
        "utils.noise.*",
        "utils.cellular.*",
        "utils.cfractal.*",
        "java.util.*",
        "geneticimage.*",
        };

    private LinkedList userImportPackages = new LinkedList();
    private LinkedList userImportClasses = new LinkedList();

    // root node of the parse tree
    private static ASTFnTopLevel fnTopLevel;

    public ASTFnTopLevel(int id) {
      super(id);
      fnTopLevel = this;
    }

    public ASTFnTopLevel(FnParser p, int id) {
	super(p, id);
	fnTopLevel = this;
    }

    // Set accessor for user imports. 
    public void addUserImport(String importName) {
	if (importName.endsWith("*")) {
	    /* The import name ends with a "*"; trim off the ".*"
               suffix and add the resulting package name to
               userImportPackages. */
	    userImportPackages.add(importName.substring(0, importName.length() - 2));
	}
	else {
	    /* The import name doesn't end in "*"; it is an import of
               a specific class. */
	    userImportClasses.add(importName);
	}
    }

    /* Adds all user imports (packages and classes) to the
       ClassDescriptor. */
    public void addUserImports(ClassDescriptor c) {
	ListIterator packageIter = userImportPackages.listIterator();
	while(packageIter.hasNext()) {
	    c.addPackageImport((String)packageIter.next() + ".*");
	}
	
	ListIterator classIter = userImportClasses.listIterator();
	while(classIter.hasNext()) {
	    c.addPackageImport((String)classIter.next());
	}
    }

    /* Get accessor for user package imports. Returns a ListIterator
       for the package imports. */
    public Iterator getUserImportPackages() {
	return userImportPackages.listIterator();
    }

    public Iterator getUserImportClasses()
    {
	return userImportClasses.listIterator();
    }

    /* Public get accessor for the unique ASTFnTopLevel reference. */
    public static ASTFnTopLevel getFnTopLevel() {
	return fnTopLevel;
    }

    public ClassDescriptor compileToJava() throws CompileException 
    {
	SimpleNode n;
        
        ClassDescriptor functionGroup = new ClassDescriptor();
        
        functionGroup.className = fnGroup;
        functionGroup.packageName = fnPackage;
        functionGroup.addClassModifier("public");
        functionGroup.addInterface("FunctionGroup");
        functionGroup.addInterface("java.io.Serializable");
	
	// Add imports
	for(int i = 0; i < importPackages.length; i++) 
	    functionGroup.addPackageImport(importPackages[i]);
	addUserImports(functionGroup);
        
        MethodDescriptor getFunctionsMeth = new MethodDescriptor();
        getFunctionsMeth.methodName = "getFunctions";
        getFunctionsMeth.addModifier("public");
        getFunctionsMeth.addModifier("List<NodeFunction>");
        getFunctionsMeth.addToBlockBody(new CodeStringDescriptor(
                "List<NodeFunction> functions = new LinkedList();"
                ));
        for(int i =0; i < jjtGetNumChildren(); i++) {
	    n = (SimpleNode)jjtGetChild(i);
	    if ( (FnParserTreeConstants.jjtNodeName[n.id].equals("FnDefinition"))) {
                ASTFnDefinition fnDef = (ASTFnDefinition)n;
                getFunctionsMeth.addToBlockBody(new CodeStringDescriptor(
                        "functions.add( new "+fnDef.getFnName()+"() );"
                        ));
            }
        }
        getFunctionsMeth.addToBlockBody(new CodeStringDescriptor(
                "return functions;"
                ));
        functionGroup.addMethod(getFunctionsMeth);
        
        MethodDescriptor buildMeth = new MethodDescriptor();
        buildMeth.methodName = "build";
        buildMeth.addModifier("public");
        buildMeth.addModifier("NodeFunction");
        buildMeth.addArgument("Class<? extends NodeFunction>","nfClass");
        buildMeth.addArgument("NodeFunctionFactory","nff");
        
        // go through sub groups and test this
        buildMeth.addToBlockBody(new CodeStringDescriptor(
                "NodeFunction r;"
                ));
        for(int i =0; i < jjtGetNumChildren(); i++) {
	    n = (SimpleNode)jjtGetChild(i);
	    if ( (FnParserTreeConstants.jjtNodeName[n.id].equals("FnDefinition"))) {
                ASTFnDefinition fnDef = (ASTFnDefinition)n;
                buildMeth.addToBlockBody(new CodeStringDescriptor(
                        "if(nfClass == " + fnDef.getFnName() + ".class)"
                        ));
                if(fnDef.isNodeBase())
                    buildMeth.addToBlockBody(new CodeStringDescriptor(
                        "    if(nff == null) return new "+fnDef.getFnName()+"(); else return new "+fnDef.getFnName()+"(nff);"
                        ));
                else
                    buildMeth.addToBlockBody(new CodeStringDescriptor(
                        "    return new "+fnDef.getFnName()+"();"
                        ));
            }
        }
        buildMeth.addToBlockBody(new CodeStringDescriptor(
                "return null;"
                ));
        
        functionGroup.addMethod(buildMeth);

	//Vector allFunctions = new Vector();

	for(int i =0; i < jjtGetNumChildren(); i++) {
	    // Loop through the children nodes, compiling functions
	    
	    n = (SimpleNode)jjtGetChild(i);
	    if ( (FnParserTreeConstants.jjtNodeName[n.id].equals("FnDefinition"))) {
                
                ASTFnDefinition fnDef = (ASTFnDefinition)n;
		ClassDescriptor function = fnDef.compileToJava();
		functionGroup.addNestedClass(function);
	    }
	}
	
        return functionGroup;
    }
}


