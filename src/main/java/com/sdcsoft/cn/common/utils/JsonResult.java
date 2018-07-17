package com.sdcsoft.cn.common.utils;

public class JsonResult {
	
	private Integer code;//
	private String msg;//
	private Integer orgId;

	public JsonResult() {
		super();
	}
	
	public JsonResult(Integer code, String msg,Integer orgId) {
		super();
		this.code = code;
		this.msg = msg;
		this.orgId=orgId;
	}

	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
