package com.mvc.progress;

import org.apache.commons.fileupload.ProgressListener;

import com.mvc.controller.ProcessInfo;

/**
 * 文件上传进度计算
 * @description:
 * @author 刘浩
 * @date 2015-6-12 下午3:45:47 
 * @version V1.0  
 *
 */
public class FileUploadListener implements ProgressListener {
	private ProcessInfo processInfo;

	/**
	 * 
	 */
	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		
		ProcessInfo pri = new ProcessInfo();
		pri.itemNum = pItems;
		pri.readSize = pBytesRead;
		pri.totalSize = pContentLength;
		pri.show = pBytesRead + "/" + pContentLength + " byte";
		pri.rate = Math.round(new Float(pBytesRead) / new Float(pContentLength)
				* 100);
		this.processInfo = pri;
	}

	public ProcessInfo getProcessInfo() {
		return processInfo;
	}

	
}
