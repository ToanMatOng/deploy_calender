package urban.intership.calender.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urban.intership.calender.Model.Role;
import urban.intership.calender.Request.CreateRoleRequest;
import urban.intership.calender.Service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // Tạo mới một vai trò
    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody CreateRoleRequest request) {
        System.out.println("Received request to create role");
        Role role = roleService.createRole(request.getName(), request.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    // Lấy tất cả vai trò
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Lấy vai trò theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    // Cập nhật vai trò
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id,
                                           @RequestParam String name,
                                           @RequestParam String description) {
        Role updatedRole = roleService.updateRole(id, name, description);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }

    // Xóa vai trò
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
