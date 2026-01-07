
package org.guatgames.objects;

/**
 *
 * @author guatgames
 */
public class HyprBind {
    
    String modifier;
    String key;
    String dispatcher;
    String params;

    public HyprBind() {
    }

    public HyprBind(String modifier, String key, String dispatcher, String params) {
        this.modifier = modifier;
        this.key = key;
        this.dispatcher = dispatcher;
        this.params = params;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(String dispatcher) {
        this.dispatcher = dispatcher;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
    
}
