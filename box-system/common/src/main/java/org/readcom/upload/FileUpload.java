package org.readcom.upload;

import org.readcom.entity.view.ResultMessage;

import java.io.InputStream;

/**
 * @program: Reader
 * @description:
 * @author: zhangxiaoyu
 * @create: 2025-04-21 14:45
 **/
public abstract class FileUpload implements Upload{
    @Override
    public ResultMessage saveFile(InputStream inputStream) {
        //获取到后缀名，并创建对应的随机文件名

        boolean save = save(inputStream);

        //对于后续结果对象的封装
        return null;
    }

    protected abstract boolean save(InputStream inputStream);
}
