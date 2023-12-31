package com.essam.student.management.projection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@JsonPropertyOrder({"id", "username", "email", "name"})
@ApiModel
public interface UserProjection {

    @ApiModelProperty(position = 1)
    Long getId();

    @ApiModelProperty(position = 2)
    public String getEmail();

    @ApiModelProperty(position = 3)
    public String getName();

    @ApiModelProperty(position = 4)
    public String getUsername();
}
