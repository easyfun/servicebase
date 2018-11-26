package com.efun.codeimpl.handler;

import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codedata.redis.dao.ApplyMobileCodeRedisDAO;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.task.TaskHandler;
import com.efun.framework.task.entity.TaskPO;
import com.efun.framework.task.handler.ITaskHandler;
import com.efun.framework.task.handler.TaskExecuteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@TaskHandler
public class SendCodeSmsHandler implements ITaskHandler {
    private static final Logger logger = LoggerFactory.getLogger(SendCodeSmsHandler.class);

    @Autowired
    private ApplyMobileCodeRedisDAO applyMobileCodeRedisDAO;

    @Override
    public TaskExecuteResult execute(TaskPO taskPO, Object params) {
        ApplyMobileCodeParamDTO applyMobileCodeParamDTO = applyMobileCodeRedisDAO.get(taskPO.getTaskKey());
        logger.info("Send code sms success, applyMobileCodeParamDTO={}", JsonUtil.toJSONString(applyMobileCodeParamDTO));
        return TaskExecuteResult.success();
    }
}
