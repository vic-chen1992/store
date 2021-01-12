package com.vic.test.store.product.exception;

import com.vic.test.common.Enume.BizCodeEnume;
import com.vic.test.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){

        log.error("错误：",throwable);
        return R.error(BizCodeEnume.UNKNOW_EXCEPTION.getCode(),BizCodeEnume.UNKNOW_EXCEPTION.getMsg());
    }

}
