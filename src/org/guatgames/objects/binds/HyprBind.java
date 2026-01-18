
package org.guatgames.objects.binds;

/**
 *
 * @author guatgames
 */
public class HyprBind {

    private String bind;
    private String modifier;
    private String key;
    private String dispatcher;
    private String params;

    public HyprBind() {
    }

    public HyprBind(String modifier, String key, String dispatcher, String params) {
        this.modifier = modifier;
        this.key = key;
        this.dispatcher = dispatcher;
        this.params = params;
    }

    public HyprBind(String bind, String modifier, String key, String dispatcher, String params) {
        this.bind = bind;
        this.modifier = modifier;
        this.key = key;
        this.dispatcher = dispatcher;
        this.params = params;
    }

    public String getBind() { return bind; }

    public void setBind(String bind) { this.bind = bind; }

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
