package org.nofdev.plugin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 从 Ioc 容器中选取可用插件
 */
@Component
public class IocPluginManager<T> implements PluginManager<T> {

    @Autowired
    private ApplicationContext ioc;

    @Value("${nofdev.plugin}")
    private String[] names;

    public IocPluginManager(ApplicationContext ioc, String... names) {
        this.ioc = ioc;
        this.names = names;
    }

    public T get() throws NoPluginCanWorkException {
        for (String name : names) {
            try {
                Plugin plugin = ioc.getBean(Plugin.class, name);//todo
                if (plugin.canWork())
                    return (T) plugin;
            } catch (BeansException e) {
            }
        }
        throw new NoPluginCanWorkException();
    }

    public List<T> gets() {
        List<T> aList = new ArrayList<T>(names.length);
        for (String name : names) {
            try {
                Plugin plugin = ioc.getBean(Plugin.class, name);//todo
                if (plugin.canWork())
                    aList.add((T) plugin);
            } catch (BeansException e) {
            }
        }
        return aList;
    }
} 