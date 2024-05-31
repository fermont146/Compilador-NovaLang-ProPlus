/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico;
import ASemantico.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MONTOYA EL HACKERMAN
 * 
 */
public class ASParser {
    private ASLexer lexer;
    private ASToken currentToken;
    private ASToken peekToken;

    public ASParser(ASLexer lexer) {
        this.lexer = lexer;
        this.nextToken();
        this.nextToken();
    }

    private void nextToken() {
        this.currentToken = this.peekToken;
        this.peekToken = this.lexer.nextToken();
    }

    public Program parseProgram() {
        List<ASTNode> statements = new ArrayList<>();
        while (!this.currentToken.type.equals("EOF")) {
            ASTNode stmt = this.parseStatement();
            if (stmt != null) {
                statements.add(stmt);
            }
            this.nextToken();
        }
        return new Program(statements);
    }

    private ASTNode parseStatement() {
        if (this.currentToken.type.equals("IDENT")) {
            return this.parseAssignmentStatement();
        }
        return null;
    }

    private ASTNode parseAssignmentStatement() {
        String varName = this.currentToken.value;
        this.nextToken();
        if (!this.currentToken.type.equals("ASSIGN")) {
            return null;
        }
        this.nextToken();
        ASTNode value = this.parseExpression();
        if (this.peekToken.type.equals("SEMICOLON")) {
            this.nextToken();
        }
        return new Assignment(varName, value);
    }

    private ASTNode parseExpression() {
        if (this.currentToken.type.equals("INT")) {
            return new Constant(Integer.parseInt(this.currentToken.value));
        } else if (this.currentToken.type.equals("IDENT")) {
            return new Variable(this.currentToken.value);
        }
        return null;
    }
}