package org.nofdev.plugin;

import java.util.ArrayList;
import java.util.List;

public class SimplePluginManager<T> implements PluginManager<T> {

    private List<Plugin> list = new ArrayList<Plugin>();

    public SimplePluginManager(String... classNames) throws PluginException {
        if (classNames != null)
            for (String className : classNames)
                loadPlugin(className);
    }

    public SimplePluginManager(Class<? extends T>... classNames) throws PluginException {
        if (classNames != null)
            for (Class<? extends T> pluginClass : classNames)
                loadPlugin(pluginClass);
    }

    public T get() throws NoPluginCanWorkException {
        for (Plugin plugin : list)
            if (plugin.canWork())
                return (T) plugin;
        throw new NoPluginCanWorkException();
    }

    public List<T> gets() {
        List<T> aList = new ArrayList<T>(list.size());
        for (Plugin plugin : list)
            if (plugin.canWork())
                aList.add((T) plugin);
        return aList;
    }

    protected void loadPlugin(Class<? extends T> pluginClass) throws PluginException {
        if (pluginClass != null)
            try {
                list.add((Plugin) pluginClass.newInstance());
            } catch (Throwable e) {
            }
    }

    private void loadPlugin(String pluginClassName) throws PluginException {
        if (pluginClassName != null)
            try {
                loadPlugin((Class<? extends T>) Thread.currentThread()
                        .getContextClassLoader()
                        .loadClass(pluginClassName));
            } catch (Throwable e) {
            }
    }
} 