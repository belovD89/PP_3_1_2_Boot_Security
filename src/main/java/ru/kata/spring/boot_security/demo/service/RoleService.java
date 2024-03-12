package ru.kata.spring.boot_security.demo.service;

import net.bytebuddy.dynamic.DynamicType;
import org.hibernate.mapping.Set;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.HashSet;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public Set<Role> findAllRoles() {
        return new HashSet<>(roleRepository.findAll());
    }

    @Transactional
    public DynamicType.Builder.FieldDefinition.Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }
}
