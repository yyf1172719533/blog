package com.timain.web.result;

import lombok.Data;

/**
 * 输出信息
 * @author yyf
 * @version 1.0
 * @date 2020/3/3 22:10
 */
@Data
public class RequestObj {

    private String url;
    private String ip;
    private String classMethod;
    private Object[] args;

    public RequestObj() {
    }

    public RequestObj(String url, String ip, String classMethod, Object[] args) {
        this.url = url;
        this.ip = ip;
        this.classMethod = classMethod;
        this.args = args;
    }
}
