package com.nelio.workshopmongo.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

    /**
     * Classe utilitária para tratamento de parâmetros enviados via URL.
     */
    public static String decodeParam(String text) {
        try {
            // Decodifica o texto da URL (ex: transforma %20 em espaço, %40 em @).
            // Necessário porque navegadores codificam caracteres especiais para trafegar na web.
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // Se houver erro na decodificação (padrão de caracteres inválido), retorna vazio.
            return "";
        }
    }
}