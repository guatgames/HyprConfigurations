
package org.guatgames.controllers;

/**
 *
 * @author guatgames
 */

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.guatgames.objects.HyprBind;

public class HyprConfigReader {

    // Regex para capturar: bind = MODIFICADOR, TECLA, DISPATCHER, PARAMETROS
    private static final String BIND_REGEX = "^\\s*bind\\s*=\\s*([^,]+),\\s*([^,]+),\\s*([^,]+),\\s*(.*)$";

    public List<HyprBind> getBinds(String path) {
        List<HyprBind> binds = new ArrayList<>();
        Pattern pattern = Pattern.compile(BIND_REGEX);

        try {
            List<String> lines = Files.readAllLines(Paths.get(path));

            for (String line : lines) {
                Matcher matcher = pattern.matcher(line.trim());
                
                if (matcher.find()) {
                    HyprBind bind = new HyprBind();
                    bind.setModifier(matcher.group(1).trim());
                    bind.setKey(matcher.group(2).trim());
                    bind.setDispatcher(matcher.group(3).trim());
                    bind.setParams(matcher.group(4).trim());
                    
                    binds.add(bind);
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo el archivo: " + e.getMessage());
            System.out.println(e);
        }
        return binds;
    }
}