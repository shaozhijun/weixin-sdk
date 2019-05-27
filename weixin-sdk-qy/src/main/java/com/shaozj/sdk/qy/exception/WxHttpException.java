package com.shaozj.sdk.qy.exception;


public class WxHttpException extends RuntimeException {
    
    /**
     * <p>Field serialVersionUID: TODO</p>
     */
    private static final long serialVersionUID = 1L;
    
    private Integer code;

    public WxHttpException(Throwable cause) {
        super(cause);
    }
    
    public WxHttpException(String msg) {
        super(msg);
    }
    
    public WxHttpException(Integer code) {
        this.code = code;
    }

    public WxHttpException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public WxHttpException(int code, String msg) {
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
