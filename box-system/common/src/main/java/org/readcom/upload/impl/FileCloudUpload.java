package org.readcom.upload.impl;

import org.readcom.entity.view.ResultMessage;
import org.readcom.upload.FileUpload;
import org.readcom.upload.Upload;

import java.io.InputStream;

/**
 * @program: Reader
 * @description: 上传文件到云
 * @author: zhangxiaoyu
 * @create: 2025-04-21 14:26
 **/
public class FileCloudUpload extends FileUpload {


    @Override
    protected boolean save(InputStream inputStream) {
        return false;
    }
}
