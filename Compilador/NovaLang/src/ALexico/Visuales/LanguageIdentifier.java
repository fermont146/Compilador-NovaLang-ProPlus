 
package ALexico.Visuales;
import java.util.regex.*;

public class LanguageIdentifier {

    // Definir expresiones regulares para identificar los lenguajes
    private static final Pattern PL_SQL_PATTERN = Pattern.compile("(?i)\\bBEGIN\\b|\\bEND\\b|\\bDBMS_OUTPUT\\.PUT_LINE\\b");
    private static final Pattern T_SQL_PATTERN = Pattern.compile("(?i)\\bSELECT\\b|\\bFROM\\b|\\bWHERE\\b");
    private static final Pattern CPP_PATTERN = Pattern.compile("#include\\s*<.*>|int\\s+main\\s*\\(.*\\)|std::cout|std::endl|\\busing\\s+namespace\\s+std\\b");
    private static final Pattern PASCAL_PATTERN = Pattern.compile("(?i)\\bprogram\\b|\\bbegin\\b|\\bend\\b|writeln\\b");
    private static final Pattern JS_PATTERN = Pattern.compile("console\\.log|let\\s+|const\\s+|function\\s+");
    private static final Pattern HTML_PATTERN = Pattern.compile("<!DOCTYPE\\s+html>|<html>|<head>|<body>|<p>|</p>|</html>|<title>|</title>");
    private static final Pattern PYTHON_PATTERN = Pattern.compile("\\bdef\\s+|print\\(|\\bimport\\s+|if\\s+__name__|\\bclass\\s+|\\bself\\b");

    // Método para identificar el lenguaje de programación
    public static String identifyLanguage(String input) {
        if (PL_SQL_PATTERN.matcher(input).find()) {
            return "PL/SQL";
        } else if (T_SQL_PATTERN.matcher(input).find()) {
            return "T-SQL";
        } else if (CPP_PATTERN.matcher(input).find()) {
            return "C++";
        } else if (PASCAL_PATTERN.matcher(input).find()) {
            return "Pascal";
        } else if (JS_PATTERN.matcher(input).find()) {
            return "JavaScript";
        } else if (HTML_PATTERN.matcher(input).find()) {
            return "HTML";
        } else if (PYTHON_PATTERN.matcher(input).find()) {
            return "Python";
        } else {
            return "Unknown";
        }
    }
}



