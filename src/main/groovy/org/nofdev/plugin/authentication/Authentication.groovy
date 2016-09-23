package org.nofdev.plugin.authentication

/**
 * Created by Liutengfei on 2016/9/23 0023.
 */
interface Authentication {
    void tokenToUser(String methodName, Map<String, String> header)
}
