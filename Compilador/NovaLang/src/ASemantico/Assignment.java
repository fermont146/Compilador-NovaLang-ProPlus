/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico;

/**
 *
 * @author monTOya
 */
public class Assignment extends ASTNode {
    String varName;
    ASTNode value;

    public Assignment(String varName, ASTNode value) {
        this.varName = varName;
        this.value = value;
    }
}