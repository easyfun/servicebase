package com.efun.codeimpl.service.impl;

import com.efun.codeimpl.service.CodeService;
import com.efun.framework.common.exception.BusinessException;
import com.efun.framework.common.exception.CommonErrorCode;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CodeServiceImpl implements CodeService {
    Random random = new Random();

    @Override
    public String createDigitalCode(int digit) {
        if (digit < 1) {
            throw new BusinessException(CommonErrorCode.paramError);
        }

        int code = Math.abs(random.nextInt());
        int base = (int) Math.pow(10, digit);
        code = code % base;
        return String.format("%06d", code);
    }

    @Override
    public String createDigitalCode6() {
        return createDigitalCode(6);
    }
}
