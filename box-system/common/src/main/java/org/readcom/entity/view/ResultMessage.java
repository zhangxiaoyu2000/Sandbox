package org.readcom.entity.view;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @program: Reader
 * @description: 结果对象
 * @author: zhangxiaoyu
 * @create: 2025-04-21 12:55
 **/
@Component
public class ResultMessage<T> {

    private Status status;


    private T data;

    public ResultMessage<T> success(String Message,T data){
        status = Status.OK;
        this.data=data;
        return this;
    }

    public ResultMessage<T> errorNotFound(){
        status=Status.ERROR_NOTFOUND;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
