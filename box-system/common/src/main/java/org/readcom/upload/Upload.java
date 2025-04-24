package org.readcom.upload;

import org.readcom.entity.view.ResultMessage;

import java.io.InputStream;

/**
 * @program: Reader
 * @description: 文件上传接口
 * @author: zhangxiaoyu
 * @create: 2025-04-21 14:34
 **/
public interface Upload {
    ResultMessage saveFile(InputStream inputStream);
}
