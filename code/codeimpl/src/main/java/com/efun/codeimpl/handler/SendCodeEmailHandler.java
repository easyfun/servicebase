package com.efun.codeimpl.handler;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codedata.redis.dao.ApplyEmailCodeRedisDAO;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.redis.RedisService;
import com.efun.framework.task.TaskHandler;
import com.efun.framework.task.entity.TaskPO;
import com.efun.framework.task.handler.ITaskHandler;
import com.efun.framework.task.handler.TaskExecuteResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@TaskHandler
public class SendCodeEmailHandler implements ITaskHandler {
    private static final Logger logger = LoggerFactory.getLogger(SendCodeEmailHandler.class);

    @Autowired
    private ApplyEmailCodeRedisDAO applyEmailCodeRedisDAO;

    @Override
    public TaskExecuteResult execute(TaskPO taskPO, Object params) {
        ApplyEmailCodeParamDTO applyEmailCodeParamDTO = applyEmailCodeRedisDAO.get(taskPO.getTaskKey());
        logger.info("Send code email success, applyEmailCodeParamDTO={}", JsonUtil.toJSONString(applyEmailCodeParamDTO));
        return TaskExecuteResult.success();
    }
}
