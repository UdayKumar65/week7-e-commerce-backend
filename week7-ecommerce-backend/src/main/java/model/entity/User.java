package model.entity;

import enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRole(Role user) {
		// TODO Auto-generated method stub
		
	}
}