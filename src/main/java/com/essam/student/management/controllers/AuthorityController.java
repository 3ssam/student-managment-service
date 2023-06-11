package com.essam.student.management.controllers;

import com.essam.student.management.requests.AuthorityRequest;
import com.essam.student.management.response.ApiResponse;
import com.essam.student.management.services.AuthorityService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authority")
@Api(tags = "Authority", description = "this API for Do any CRUD Operation on Authority Entity")
public class AuthorityController {
    private static Logger logger = LogManager.getLogger(AuthorityController.class);


    @Autowired
    private AuthorityService authorityService;

    @PreAuthorize("hasAuthority('CREATE_Authority')")
    @PostMapping()
    public ApiResponse createAuthority(@Validated @RequestBody AuthorityRequest request) throws Exception {
        logger.info("create Authority received request");
        return ApiResponse.created(authorityService.createAuthority(request));
    }

    @PreAuthorize("hasAuthority('UPDATE_Authority')")
    @PutMapping("{AuthorityId}")
    public ApiResponse updateAuthority(@PathVariable Long AuthorityId, @Validated @RequestBody AuthorityRequest request) throws Exception {
        logger.info("update Authority received request");
        return ApiResponse.updated(authorityService.updateAuthority(request, AuthorityId));
    }

    @PreAuthorize("hasAuthority('DELETE_Authority')")
    @DeleteMapping("{AuthorityId}")
    public void deleteAuthority(@PathVariable Long authorityId) {
        logger.info("delete Authority received request");
        authorityService.deleteAuthority(authorityId);
    }

    @PreAuthorize("hasAuthority('READ_Authority')")
    @GetMapping({"{AuthorityId}"})
    public ApiResponse getAuthority(@PathVariable Long authorityId) throws Exception {
        logger.info("get Authority received request");
        return ApiResponse.ok(authorityService.getAuthority(authorityId));
    }

    @PreAuthorize("hasAuthority('READ_Authorities')")
    @GetMapping()
    public ApiResponse getAuthorities() {
        logger.info("get Authorities received request");
        return ApiResponse.ok(authorityService.getAllAuthorities());
    }


}
