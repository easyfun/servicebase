package com.efun.codeimpl.service.impl;

import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codeapi.dto.VerifyMobileCodeParamDTO;
import com.efun.codeapi.exception.CodeErrorCode;
import com.efun.codedata.redis.dao.ApplyMobileCodeRedisDAO;
import com.efun.codeimpl.handler.SendCodeSmsHandler;
import com.efun.codeimpl.service.CodeService;
import com.efun.codeimpl.service.MobileCodeService;
import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.exception.BusinessException;
import com.efun.framework.task.Task;
import com.efun.framework.task.TaskManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MobileCodeServiceImpl implements MobileCodeService {
    private static final Logger logger = LoggerFactory.getLogger(MobileCodeServiceImpl.class);

    @Autowired
    private CodeService codeService;

    @Autowired
    private TaskManager taskManager;

    @Autowired
    private ApplyMobileCodeRedisDAO applyMobileCodeRedisDAO;

    /**
     * 异步接口
     * 允许请求丢失
     */
    @Override
    public BaseResultDTO applyMobileCode(ApplyMobileCodeParamDTO applyMobileCodeParamDTO) {
        //校验请求参数
        boolean set = applyMobileCodeRedisDAO.set(applyMobileCodeParamDTO);
        if (!set) {
            throw new BusinessException(CodeErrorCode.applyTooFast);
        }

        String code = codeService.createDigitalCode6();
        applyMobileCodeParamDTO.setParam(code);

        Task task = new Task();
        String taskKey = ApplyMobileCodeRedisDAO.getParamKey(applyMobileCodeParamDTO.getCodeMode(), applyMobileCodeParamDTO.getMobile());
        task.setTaskKey(taskKey);
        task.setHandler(SendCodeSmsHandler.class.getSimpleName());
        taskManager.pushTask(task);
        return BaseResultDTO.accepted();
    }

    @Override
    public BaseResultDTO verifyMobileCode(VerifyMobileCodeParamDTO verifyMobileCodeParamDTO) {
        String codeKey = ApplyMobileCodeRedisDAO.getCodeKey(verifyMobileCodeParamDTO.getCodeMode(), verifyMobileCodeParamDTO.getMobile());
        String code = applyMobileCodeRedisDAO.getCode(codeKey);
        if (codeKey == null || !verifyMobileCodeParamDTO.getCode().equals(codeKey)) {
            return BaseResultDTO.fail(CodeErrorCode.codeError.getFailCode());
        }
        return BaseResultDTO.success();
    }
}
