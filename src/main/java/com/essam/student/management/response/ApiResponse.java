package com.essam.student.management.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonPropertyOrder({"code", "title", "message", "body"})
@ApiModel
public class ApiResponse {
    @ApiModelProperty(position = 1)
    private int code;

    @ApiModelProperty(position = 2)
    private String title;

    @ApiModelProperty(position = 3)
    private String message;

    @ApiModelProperty(position = 4)
    private Object body;

    public ApiResponse(int code, String title, String message, Object body) {
        this.code = code;
        this.title = title;
        this.message = message;
        this.body = body;
    }

    public static ApiResponse ok(Object body) {
        return ok("", "", body);
    }

    public static ApiResponse ok(String title, String message, Object body) {
        return new ApiResponse(200, title, message, body);
    }

    public static ApiResponse created(String title, String message, Object body) {
        return new ApiResponse(201, title, message, body);
    }

    public static ApiResponse validationError(String title, String message, Object body) {
        return new ApiResponse(400, title, message, body);
    }

    public static ApiResponse created(Object body) {
        return created("success", "created-successfully", body);
    }

    public static ApiResponse updated(Object body) {
        return created("success", "updated-successfully", body);
    }

    public static ApiResponse deleted(Object body) {
        return created("success", "deleted-successfully", body);
    }
}
