package com.essam.student.management.services;

import com.essam.student.management.models.Authority;
import com.essam.student.management.models.Role;
import com.essam.student.management.projection.RoleProjection;
import com.essam.student.management.repositories.RoleRepository;
import com.essam.student.management.requests.RoleRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AuthorityService authorityService;

    @Transactional
    public RoleProjection createRole(RoleRequest roleRequest) {
        Role role = new Role();
        role.setName(roleRequest.getName());
        role.setStatus(roleRequest.getStatus());
        role = roleRepository.save(role);
        return roleRepository.getRoleById(role.getId());
    }

    @Transactional
    public RoleProjection updateRole(RoleRequest roleRequest, Long id) throws Exception {
        Role role = roleRepository.findById(id).get();
        if (role == null) {
            throw new Exception("Role not found");
        }
        role.setStatus(roleRequest.getStatus());
        role = roleRepository.save(role);
        return roleRepository.getRoleById(role.getId());
    }


    public List<RoleProjection> getAllRoles() {
        return roleRepository.findAllBy();
    }

    public RoleProjection getRole(Long id) throws Exception {
        RoleProjection roleProjection = roleRepository.getRoleById(id);
        if (roleProjection == null) {
            throw new Exception("Role not found");
        }
        return roleProjection;
    }

    public Role getRoleObject(Long id) throws Exception {
        Optional<Role> role = roleRepository.findById(id);
        if (role == null) {
            throw new Exception("Role not found");
        }
        return role.get();
    }

    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Transactional
    public void assignAuthorityToRole(Long roleId, Long authorityId) throws Exception {
        Role role = roleRepository.findById(roleId).get();
        if (role == null) {
            throw new Exception("Role not found");
        }
        Authority authority = authorityService.getAuthorityById(authorityId);
        if (role == null) {
            throw new Exception("Authority not found");
        }
        role.getAuthorities().add(authority);
        roleRepository.save(role);
    }

    @Transactional
    public void assignAuthorityToRole(Long roleId, String authorityName) throws Exception {
        Role role = roleRepository.findById(roleId).get();
        if (role == null) {
            throw new Exception("Role not found");
        }
        Authority authority = authorityService.getAuthorityByName(authorityName);
        if (role == null) {
            throw new Exception("Authority not found");
        }
        role.getAuthorities().add(authority);
        roleRepository.save(role);
    }

    public Role getRoleByName(String name) throws Exception {
        Role role = roleRepository.getRoleByName(name);
        if (role == null) {
            throw new Exception("Role not found");
        }
        return role;
    }


}
