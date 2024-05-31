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
public class ASLexer {
    private String input;
    private int position;
    private int readPosition;
    private char ch;

    public ASLexer(String input) {
        this.input = input;
        this.position = 0;
        this.readPosition = 0;
        this.readChar();
    }

    private void readChar() {
        if (this.readPosition >= this.input.length()) {
            this.ch = '\0';
        } else {
            this.ch = this.input.charAt(this.readPosition);
        }
        this.position = this.readPosition;
        this.readPosition += 1;
    }

    public ASToken nextToken() {
        ASToken token;
        switch (this.ch) {
            case '=':
                token = new ASToken("ASSIGN", "=");
                break;
            case ';':
                token = new ASToken("SEMICOLON", ";");
                break;
            case '\0':
                token = new ASToken("EOF", "");
                break;
            default:
                if (Character.isLetter(this.ch)) {
                    String literal = this.readIdentifier();
                    return new ASToken("IDENT", literal);
                } else if (Character.isDigit(this.ch)) {
                    String literal = this.readNumber();
                    return new ASToken("INT", literal);
                } else {
                    token = new ASToken("ILLEGAL", String.valueOf(this.ch));
                }
                break;
        }
        this.readChar();
        return token;
    }

    private String readIdentifier() {
        int startPosition = this.position;
        while (Character.isLetter(this.ch)) {
            this.readChar();
        }
        return this.input.substring(startPosition, this.position);
    }

    private String readNumber() {
        int startPosition = this.position;
        while (Character.isDigit(this.ch)) {
            this.readChar();
        }
        return this.input.substring(startPosition, this.position);
    }
}