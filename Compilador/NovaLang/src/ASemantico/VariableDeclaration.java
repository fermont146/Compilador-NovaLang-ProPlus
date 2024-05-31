/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico;

/**
 *
 * @author MONTOYA
 */
public class VariableDeclaration extends ASTNode {
    String varType;
    String varName;

    public VariableDeclaration(String varType, String varName) {
        this.varType = varType;
        this.varName = varName;
    }
}