/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico; 
import ASemantico.*;

/**
 *
 * @author MONTOYA EL HACKERMAN
 */
public class SemanticAnalyzer {
    private SymbolTable symbolTable = new SymbolTable();

    public void analyze(ASTNode node) throws Exception {
        if (node instanceof Program) {
            Program program = (Program) node;
            for (ASTNode statement : program.statements) {
                analyze(statement);
            }
        } else if (node instanceof VariableDeclaration) {
            VariableDeclaration decl = (VariableDeclaration) node;
            symbolTable.add(decl.varName, decl.varType);
        } else if (node instanceof Assignment) {
            Assignment assign = (Assignment) node;
            String varType = symbolTable.lookup(assign.varName);
            String valueType = analyzeExpression(assign.value);
            if (!varType.equals(valueType)) {
                throw new Exception("Semantic Error: Type mismatch in assignment to '" + assign.varName + "'. Expected " + varType + " but got " + valueType + ".");
            }
        } else {
            throw new Exception("Semantic Error: Unexpected AST node type.");
        }
    }

    private String analyzeExpression(ASTNode node) throws Exception {
        if (node instanceof Variable) {
            Variable var = (Variable) node;
            return symbolTable.lookup(var.name);
        } else if (node instanceof Constant) {
            Constant constant = (Constant) node;
            return constant.value.getClass().getSimpleName();
        } else {
            throw new Exception("Semantic Error: Unsupported expression node type.");
        }
    }
}