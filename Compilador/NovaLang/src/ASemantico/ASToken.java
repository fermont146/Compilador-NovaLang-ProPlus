/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico;

/**
 *
 * @author montoya
 */
 
public class ASToken {
    public String type;
    public String value;

    public ASToken(String type, String value) {
        this.type = type;
        this.value = value;
    }
}