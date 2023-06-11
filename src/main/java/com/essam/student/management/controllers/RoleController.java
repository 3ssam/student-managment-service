package com.essam.student.management.controllers;

import com.essam.student.management.requests.RoleRequest;
import com.essam.student.management.response.ApiResponse;
import com.essam.student.management.services.RoleService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
@Api(tags = "Role", description = "this API for Do any CRUD Operation on Role Entity")
public class RoleController {

    private static Logger logger = LogManager.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    @PostMapping()
    public ApiResponse createRole(@Validated @RequestBody RoleRequest request) throws Exception {
        logger.info("create Role received request");
        return ApiResponse.created(roleService.createRole(request));
    }

    @PreAuthorize("hasAuthority('UPDATE_ROLE')")
    @PutMapping("{roleId}")
    public ApiResponse updateRole(@PathVariable Long roleId, @Validated @RequestBody RoleRequest request) throws Exception {
        logger.info("update Role received request");
        return ApiResponse.updated(roleService.updateRole(request, roleId));
    }

    @PreAuthorize("hasAuthority('DELETE_ROLE')")
    @DeleteMapping("{roleId}")
    public void deleteRole(@PathVariable Long roleId) {
        logger.info("delete Role received request");
        roleService.deleteRole(roleId);
    }

    @PreAuthorize("hasAuthority('READ_ROLE')")
    @GetMapping({"{roleId}"})
    public ApiResponse getRole(@PathVariable Long roleId) throws Exception {
        logger.info("get Role received request");
        return ApiResponse.ok(roleService.getRole(roleId));
    }

    @PreAuthorize("hasAuthority('READ_ALL_ROLES')")
    @GetMapping()
    public ApiResponse getRoles() {
        logger.info("get Roles received request");
        return ApiResponse.ok(roleService.getAllRoles());
    }

    @PreAuthorize("hasAuthority('ASSIGN_AUTHORITY_TO_ROLE')")
    @GetMapping("assignAuthority/{roleId}/name")
    public void assignAuthorityToRole(@PathVariable Long roleId, @RequestParam String authorityName) throws Exception {
        logger.info("assign Authority To Role received request");
        roleService.assignAuthorityToRole(roleId, authorityName);
    }

    @PreAuthorize("hasAuthority('ASSIGN_AUTHORITY_TO_ROLE')")
    @GetMapping("assignAuthority/{roleId}/id")
    public void assignAuthorityToRole(@PathVariable Long roleId, @RequestParam Long authorityId) throws Exception {
        logger.info("assign Authority To Role received request");
        roleService.assignAuthorityToRole(roleId, authorityId);
    }


}
