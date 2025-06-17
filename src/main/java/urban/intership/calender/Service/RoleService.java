package urban.intership.calender.Service;

import urban.intership.calender.Model.Role;
import urban.intership.calender.Request.CreateRoleRequest;

import java.util.List;

public interface RoleService {
    // Trong RoleService
    public Role createRole(String name, String description);

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role updateRole(Long id, String name, String description);

    void deleteRole(Long id);
}