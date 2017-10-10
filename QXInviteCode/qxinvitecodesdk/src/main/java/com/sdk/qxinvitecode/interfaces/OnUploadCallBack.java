package com.sdk.qxinvitecode.interfaces;

/**
 * @author vijoz
 */
public interface OnUploadCallBack {
	void onSuccess(String result);

	void onFiled(String errmsg);
	
	void onStart();
	
	void onLoading(long total, long current, boolean isUploading);
}
