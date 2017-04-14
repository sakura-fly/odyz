package com.resfmt;

import net.sf.json.JSONObject;

public class DefRes {
	public static JSONObject dr(int stat,String msg) {
		JSONObject res = new JSONObject();
		res.put("stat", stat);
		res.put("msg", msg);
		return res;
	}
}
