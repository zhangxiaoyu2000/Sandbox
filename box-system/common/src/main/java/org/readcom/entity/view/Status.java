package org.readcom.entity.view;

import org.springframework.stereotype.Component;

@Component
public enum Status {
    OK(200,"OK"),
    ERROR_NOTFOUND(404,"Not Found");











    private final int code;          // final 字段，不可变
    private final String message;    // final 字段，不可变

    Status(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() { return code; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
