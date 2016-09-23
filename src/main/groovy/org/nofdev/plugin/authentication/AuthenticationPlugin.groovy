package org.nofdev.plugin.authentication

import org.nofdev.plugin.Plugin
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component

/**
 * Created by Liutengfei on 2016/9/23 0023.
 */
@Component("authenticationPlugin")
class AuthenticationPlugin implements Plugin, Authentication {
    public static final String USER = "Service-Context-User";

    @Autowired
    private ApplicationContext ioc;

    private Authentication authentication

    @Override
    boolean canWork() {
        try {
            authentication = ioc.getBean(AuthenticationService.class)
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    void tokenToUser(String methodName, Map<String, String> header) {
        authentication.tokenToUser(methodName,header)
    }
}
