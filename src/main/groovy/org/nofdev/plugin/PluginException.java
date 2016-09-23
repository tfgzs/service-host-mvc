package org.nofdev.plugin;

public class PluginException extends RuntimeException {

    public PluginException(String pluginName, Throwable cause) {
        super(String.format("插件 '%s' 不能工作", pluginName), cause);
    }

} 