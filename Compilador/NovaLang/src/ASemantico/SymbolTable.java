/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASemantico;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MONTOYA EL HACKERMAN
 */// Definición de la tabla de símbolos
public class SymbolTable {
    private Map<String, String> symbols = new HashMap<>();

    public void add(String name, String type) throws Exception {
        if (symbols.containsKey(name)) {
            throw new Exception("Semantic Error: Variable '" + name + "' already declared.");
        }
        symbols.put(name, type);
    }

    public String lookup(String name) throws Exception {
        if (!symbols.containsKey(name)) {
            throw new Exception("Semantic Error: Variable '" + name + "' not declared.");
        }
        return symbols.get(name);
    }
}