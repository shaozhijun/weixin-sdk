package com.shaozj.sdk.qy.exception;


public class WxRuntimeException extends RuntimeException {

    /**
     * <p>Field serialVersionUID: TODO</p>
     */
    private static final long serialVersionUID = 1L;
    
    private Integer code;

    public WxRuntimeException(String msg) {
        super(msg);
    }

    public WxRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public WxRuntimeException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
