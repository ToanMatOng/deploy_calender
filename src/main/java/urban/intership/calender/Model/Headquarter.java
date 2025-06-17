package urban.intership.calender.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Headquarter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ ID tự tăng
    private Long id;

    @NotBlank(message = "Tên trụ sở không được để trống")
    @Size(max = 100, message = "Tên không được dài quá 100 ký tự")
    private String name;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(max = 255, message = "Địa chỉ không được dài quá 255 ký tự")
    private String address;

    @Size(max = 500, message = "Mô tả không được dài quá 500 ký tự")
    private String description;

    @OneToMany(mappedBy = "workplace")
    private List<Event> events;

    @OneToMany(mappedBy = "place")
    private List<Businesstrip> businesstrips;

}
