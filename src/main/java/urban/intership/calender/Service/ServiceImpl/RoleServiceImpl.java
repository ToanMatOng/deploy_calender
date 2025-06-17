package urban.intership.calender.Service.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urban.intership.calender.Model.Role;
import urban.intership.calender.Repository.RoleRepository;
import urban.intership.calender.Request.CreateRoleRequest;
import urban.intership.calender.Service.RoleService;


import java.util.List;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role createRole(String name, String description) {
        Role role = new Role();
        role.setName(name);
        role.setDescription(description);
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Override
    public Role updateRole(Long id, String name, String description) {
        Role role = getRoleById(id);
        role.setName(name);
        role.setDescription(description);
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}