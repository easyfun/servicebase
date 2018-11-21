package com.efun.codeimpl.service.impl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.exception.CodeErrorCode;
import com.efun.codedata.redis.dao.ApplyEmailCodeRedisDAO;
import com.efun.codeimpl.handler.SendCodeEmailHandler;
import com.efun.codeimpl.service.CodeService;
import com.efun.codeimpl.service.EmailCodeService;
import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.exception.BusinessException;
import com.efun.framework.task.Task;
import com.efun.framework.task.TaskManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailCodeServiceImpl implements EmailCodeService {
    private static final Logger logger = LoggerFactory.getLogger(EmailCodeServiceImpl.class);

    @Autowired
    private CodeService codeService;

    @Autowired
    private TaskManager taskManager;

    @Autowired
    private ApplyEmailCodeRedisDAO applyEmailCodeRedisDAO;

    /**
     * 异步接口
     * 允许请求丢失
     */
    @Override
    public BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO applyEmailCodeParamDTO) {
        //校验请求参数
        String code = codeService.createDigitalCode6();
        applyEmailCodeParamDTO.setParam(code);

        boolean set = applyEmailCodeRedisDAO.set(applyEmailCodeParamDTO);
        if (!set) {
            throw new BusinessException(CodeErrorCode.applyTooFast);
        }

        Task task = new Task();
        String taskKey = ApplyEmailCodeRedisDAO.getKey(applyEmailCodeParamDTO.getCodeMode(), applyEmailCodeParamDTO.getEmail());
        task.setTaskKey(taskKey);
        task.setHandler(SendCodeEmailHandler.class.getSimpleName());
        taskManager.pushTask(task);
        return BaseResultDTO.accepted();
    }

    @Override
    public BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO verifyEmailCodeParamDTO) {
        return null;
    }
}
