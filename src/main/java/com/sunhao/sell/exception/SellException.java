package com.sunhao.sell.exception;


import com.sunhao.sell.enums.ResultEnum;

/**
 * @author sunhao
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(int code, String msg) {
        super(msg);
        this.code = code;
    }

}
