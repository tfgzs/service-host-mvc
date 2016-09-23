package org.nofdev.plugin.authentication;

import org.nofdev.servicefacade.AbstractBusinessException;

/**
 * Created by Liutengfei on 2016/9/23 0023.
 */
public class AuthenticationException  extends AbstractBusinessException {
    static String DEFAULT_EXCEPTION_MESSAGE = "认证失败异常";

    public AuthenticationException() {
        super(DEFAULT_EXCEPTION_MESSAGE);
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }
}