package com.example.framework.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Error implements Serializable {

    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty(value = "reason", required = true)
    private String reason;

    @JsonProperty(value = "message")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonProperty(value = "status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer status;

    public Error() {
        super();
    }

    public Error(String code, String reason, Integer status) {
        this.code = code;
        this.reason = reason;
        this.status = status;
    }

    public Error(String code, String reason, String message, Integer status) {
        this.code = code;
        this.reason = reason;
        this.message = message;
        this.status = status;
    }

}