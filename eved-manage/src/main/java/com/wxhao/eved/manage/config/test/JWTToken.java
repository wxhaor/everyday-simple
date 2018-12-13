package com.wxhao.eved.manage.config.test;

import org.apache.shiro.authc.HostAuthenticationToken;

/**
 * @author wxhao
 * @date 2018/11/13
 */
public class JWTToken implements HostAuthenticationToken {
    private String token;
    private String host;
    public JWTToken(String token) {
        this(token, null);
    }
    public JWTToken(String token, String host) {
        this.token = token;
        this.host = host;
    }
    public String getToken(){
        return this.token;
    }
    public String getHost() {
        return host;
    }
    @Override
    public Object getPrincipal() {
        return token;
    }
    @Override
    public Object getCredentials() {
        return token;
    }
    @Override
    public String toString(){
        return token + ':' + host;
    }
}
