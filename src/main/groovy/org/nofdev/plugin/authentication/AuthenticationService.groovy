package org.nofdev.plugin.authentication

import org.nofdev.servicefacade.ServiceContextHolder

/**
 * Created by Liutengfei on 2016/9/23 0023.
 */
class AuthenticationService implements Authentication {
    @Override
    void tokenToUser(String methodName, Map<String, String> header) {
        if (methodName.startsWith("my") || methodName.endsWith("ForMe")) {
            String token = header.get("X-Auth-Token")
            if (token) {
                //todo 根据token查询出当前登录的用户信息
                String userId = "111111"
                //将查询出来的信息存入到ThreadLocal<ServiceContext>
                def serviceContext = ServiceContextHolder.serviceContext
                serviceContext.put(AuthenticationPlugin.USER, userId)
            } else {
                throw new AuthenticationException("认证失败异常")
            }
        }
    }
}
