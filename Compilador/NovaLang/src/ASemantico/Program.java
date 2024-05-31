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
import java.util.List;

public class Program extends ASTNode {
    List<ASTNode> statements;

    public Program(List<ASTNode> statements) {
        this.statements = statements;
    }
}