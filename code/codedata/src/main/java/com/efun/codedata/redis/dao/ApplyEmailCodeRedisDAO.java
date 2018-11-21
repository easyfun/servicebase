package com.efun.codedata.redis.dao;

import com.alibaba.fastjson.JSONObject;
import com.efun.codeapi.constants.CodeConstant;
import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.enums.CodeMode;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.redis.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyEmailCodeRedisDAO {
    private static final int TIMEOUT = 60000;

    @Autowired
    private RedisService redisService;

    public boolean set(ApplyEmailCodeParamDTO applyEmailCodeParamDTO) {
        String key = getKey(applyEmailCodeParamDTO.getCodeMode(), applyEmailCodeParamDTO.getEmail());
        String value = JsonUtil.toJSONString(applyEmailCodeParamDTO);
        boolean set = redisService.set(key, value, "NX", "PX", TIMEOUT);
        return set;
    }

    public ApplyEmailCodeParamDTO get(CodeMode codeMode, String eamil) {
        String key = getKey(codeMode, eamil);
        String value = redisService.get(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return JSONObject.parseObject(value, ApplyEmailCodeParamDTO.class);
    }

    public ApplyEmailCodeParamDTO get(String key) {
        String value = redisService.get(key);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return JSONObject.parseObject(value, ApplyEmailCodeParamDTO.class);
    }

    public static String getKey(CodeMode codeMode, String email) {
        return CodeConstant.SERVICE_NAME + ":" + codeMode + ":" + email;
    }
}
