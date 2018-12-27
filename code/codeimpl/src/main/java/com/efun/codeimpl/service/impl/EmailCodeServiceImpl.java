package com.efun.codeimpl.service.impl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.exception.CodeErrorCode;
import com.efun.codedata.mysql.po.CodeApply;
import com.efun.codedata.mysql.po.builder.CodeApplyBuilder;
import com.efun.codedata.redis.dao.ApplyEmailCodeRedisDAO;
import com.efun.codeimpl.handler.SendCodeEmailHandler;
import com.efun.codeimpl.service.CodeMysqlRequiresNewService;
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
    CodeService codeService;

    @Autowired
    TaskManager taskManager;

    @Autowired
    ApplyEmailCodeRedisDAO applyEmailCodeRedisDAO;

    @Autowired
    CodeMysqlRequiresNewService codeMysqlRequiresNewService;


    /**
     * 异步接口
     * 允许请求丢失
     */
    @Override
    public BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO paramDTO, CodeApply codeApply) {
        //校验请求参数
        boolean set = applyEmailCodeRedisDAO.set(paramDTO);
        if (!set) {
            throw new BusinessException(CodeErrorCode.applyTooFast);
        }

        String code = codeService.createDigitalCode6();
        BaseResultDTO resultDTO = BaseResultDTO.accepted();
        CodeApply update = CodeApplyBuilder.buildUpdate(codeApply, resultDTO);
        update.setCode(code);
        codeMysqlRequiresNewService.updateCodeApply(update);

        Task task = new Task();
        String taskKey = String.valueOf(codeApply.getId());
        task.setTaskKey(taskKey);
        task.setHandler(SendCodeEmailHandler.class.getSimpleName());
        taskManager.pushTask(task);

        return resultDTO;
    }

    @Override
    public BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO paramDTO, CodeApply codeApply) {
        String codeKey = ApplyEmailCodeRedisDAO.getCodeKey(paramDTO.getCodeMode(), paramDTO.getEmail());
        String code = applyEmailCodeRedisDAO.getCode(codeKey);
        if (code == null || !paramDTO.getCode().equals(code)) {
            throw new BusinessException(CodeErrorCode.codeError);
        }

        BaseResultDTO resultDTO = BaseResultDTO.success();
        CodeApply update = CodeApplyBuilder.buildUpdate(codeApply, resultDTO);
        codeMysqlRequiresNewService.updateCodeApply(update);

        return resultDTO;
    }

}
