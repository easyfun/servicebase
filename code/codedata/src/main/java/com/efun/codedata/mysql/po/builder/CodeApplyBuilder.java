package com.efun.codedata.mysql.po.builder;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.enums.data.CodeApplyEnums;
import com.efun.codedata.mysql.po.CodeApply;
import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.enums.Result;
import com.efun.framework.common.id.IdUtils;

import java.util.Date;

public class CodeApplyBuilder {

    public static CodeApply build(ApplyEmailCodeParamDTO paramDTO) {
        CodeApply codeApply = new CodeApply();
        codeApply.setId(IdUtils.getInstance().createFlowId());
        codeApply.setApplyId(paramDTO.getApplyId());
        codeApply.setApplyMode(CodeApplyEnums.ApplyMode.apply.name());
        codeApply.setBusinessIdMode(CodeApplyEnums.BusinessIdMode.email.name());
        codeApply.setBusinessId(paramDTO.getEmail());
        codeApply.setCode(null);
        codeApply.setIp(paramDTO.getUserIp());
        codeApply.setUserAgent(paramDTO.getUserAgent().name());
        codeApply.setResult(Result.accepted.name());
        codeApply.setFailCode(null);
        codeApply.setFailReason(null);
        Date current = new Date();
        codeApply.setCreateTime(current);
        codeApply.setUpdateTime(current);
        return codeApply;
    }

    public static CodeApply build(VerifyEmailCodeParamDTO paramDTO) {
        CodeApply codeApply = new CodeApply();
        codeApply.setId(IdUtils.getInstance().createFlowId());
        codeApply.setApplyId(paramDTO.getApplyId());
        codeApply.setApplyMode(CodeApplyEnums.ApplyMode.verify.name());
        codeApply.setBusinessIdMode(CodeApplyEnums.BusinessIdMode.email.name());
        codeApply.setBusinessId(paramDTO.getEmail());
        codeApply.setCode(null);
        codeApply.setIp(paramDTO.getUserIp());
        codeApply.setUserAgent(paramDTO.getUserAgent().name());
        codeApply.setResult(Result.accepted.name());
        codeApply.setFailCode(null);
        codeApply.setFailReason(null);
        Date current = new Date();
        codeApply.setCreateTime(current);
        codeApply.setUpdateTime(current);
        return codeApply;
    }

    public static CodeApply buildUpdate(CodeApply codeApply, BaseResultDTO resultDTO) {
        CodeApply update = new CodeApply();
        update.setId(codeApply.getId());
        update.setResult(resultDTO.getResult().name());
        update.setFailCode(resultDTO.getFailCode());
        update.setFailReason(resultDTO.getFailReason());
        Date current = new Date();
        update.setUpdateTime(current);
        return update;
    }
}
