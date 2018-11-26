package com.efun.codedata.redis.dao;

import com.alibaba.fastjson.JSONObject;
import com.efun.codeapi.constants.CodeConstant;
import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codeapi.enums.CodeMode;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyMobileCodeRedisDAO {
    private static final int TIMEOUT = 60000;

    @Autowired
    private RedisService redisService;

    public boolean set(ApplyMobileCodeParamDTO applyMobileCodeParamDTO) {
        String key = getParamKey(applyMobileCodeParamDTO.getCodeMode(), applyMobileCodeParamDTO.getMobile());
        String value = JsonUtil.toJSONString(applyMobileCodeParamDTO);
        boolean set = redisService.set(key, value, "NX", "PX", TIMEOUT);
        return set;
    }

    public ApplyMobileCodeParamDTO get(CodeMode codeMode, String eamil) {
        String key = getParamKey(codeMode, eamil);
        String value = redisService.get(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return JSONObject.parseObject(value, ApplyMobileCodeParamDTO.class);
    }

    public ApplyMobileCodeParamDTO get(String key) {
        String value = redisService.get(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return JSONObject.parseObject(value, ApplyMobileCodeParamDTO.class);
    }

    public String getCode(String key) {
        String value = redisService.get(key);
        return value;
    }

    public static String getParamKey(CodeMode codeMode, String Mobile) {
        return CodeConstant.SERVICE_NAME + ":mobileCode:param:" + codeMode + ":" + Mobile;
    }

    public static String getCodeKey(CodeMode codeMode, String Mobile) {
        return CodeConstant.SERVICE_NAME + ":mobileCode:code:" + codeMode + ":" + Mobile;
    }
}
