package org.nofdev.plugin;

/**
 * 插件
 */
public interface Plugin {
    /**
     * @return 当前插件是否能正常工作
     */
    boolean canWork();
}