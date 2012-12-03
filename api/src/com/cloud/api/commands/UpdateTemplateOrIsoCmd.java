// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.api.commands;

import org.apache.log4j.Logger;

import com.cloud.api.ApiConstants;
import com.cloud.api.BaseCmd;
import com.cloud.api.IdentityMapper;
import com.cloud.api.Parameter;

public abstract class UpdateTemplateOrIsoCmd extends BaseCmd {
    public static final Logger s_logger = Logger.getLogger(UpdateIsoCmd.class.getName());

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////

    @Parameter(name=ApiConstants.BOOTABLE, type=CommandType.BOOLEAN, description="true if image is bootable, false otherwise")
    private Boolean bootable;

    @Parameter(name=ApiConstants.DISPLAY_TEXT, type=CommandType.STRING, description="the display text of the image", length=4096)
    private String displayText;

    @IdentityMapper(entityTableName="vm_template")
    @Parameter(name=ApiConstants.ID, type=CommandType.LONG, required=true, description="the ID of the image file")
    private Long id;

    @Parameter(name=ApiConstants.NAME, type=CommandType.STRING, description="the name of the image file")
    private String templateName;

    @IdentityMapper(entityTableName="guest_os")
    @Parameter(name=ApiConstants.OS_TYPE_ID, type=CommandType.LONG, description="the ID of the OS type that best represents the OS of this image.")
    private Long osTypeId;
    
    @Parameter(name=ApiConstants.FORMAT, type=CommandType.STRING, description="the format for the image")
    private String format;
    
    @Parameter(name=ApiConstants.PASSWORD_ENABLED, type=CommandType.BOOLEAN, description="true if the image supports the password reset feature; default is false")
    private Boolean passwordEnabled;
    
    @Parameter(name=ApiConstants.SORT_KEY, type=CommandType.INTEGER, description="sort key of the template, integer")
    private Integer sortKey;

    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////

    public Boolean isBootable() {
        return bootable;
    }

    public String getDisplayText() {
        return displayText;
    }

    public Long getId() {
        return id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Long getOsTypeId() {
        return osTypeId;
    }
    
    public Boolean isPasswordEnabled() {
        return passwordEnabled;
    }
    
    public String getFormat() {
        return format;
    }
    
    public Integer getSortKey() {
    	return sortKey;
    }
}
