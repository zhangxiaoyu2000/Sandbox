package org.readcom.upload.impl;

import org.readcom.entity.view.ResultMessage;
import org.readcom.upload.FileUpload;
import org.readcom.upload.Upload;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @program: Reader
 * @description: 上传文件到本地
 * @author: zhangxiaoyu
 * @create: 2025-04-21 14:24
 **/
@Component
public class FileLocalUpload extends FileUpload {
    private String BaseUrl="";


    @Override
    protected boolean save(InputStream inputStream) {
        return false;
    }
}
