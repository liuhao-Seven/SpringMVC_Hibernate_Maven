package com.mvc.progress;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.lh.util.log.LHLog;

public class MultipartResolver extends CommonsMultipartResolver {

	/**
	 * Parse the given servlet request, resolving its multipart elements.
	 * @param request the request to parse
	 * @return the parsing result
	 * @throws MultipartException if multipart resolution failed.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
		String encoding = determineEncoding(request);
		FileUpload fileUpload = prepareFileUpload(encoding);
		LHLog.error("request==null:"+(request==null));
		if (request != null) {
			LHLog.error("parseRequest…Ë÷√");
			FileUploadListener uploadProgressListener = new FileUploadListener();
			((ServletFileUpload)fileUpload).setProgressListener(uploadProgressListener);
			request.getSession().setAttribute("uploadProgressListener",uploadProgressListener);
		}
		try {
			List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
			return parseFileItems(fileItems, encoding);
		}
		catch (FileUploadBase.SizeLimitExceededException ex) {
			request.getSession().removeAttribute("uploadProgressListener");
			throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
		}
		catch (FileUploadException ex) {
			request.getSession().removeAttribute("uploadProgressListener");
			throw new MultipartException("Could not parse multipart servlet request", ex);
		}
	}
	
	@Override
	public MultipartHttpServletRequest resolveMultipart(
			HttpServletRequest request) throws MultipartException {
		return super.resolveMultipart(request);
	}

}
