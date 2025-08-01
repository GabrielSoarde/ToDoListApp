package com.soardev.To_Do_List.model;

import com.soardev.To_Do_List.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Email obrigatório!")
    @Email(message = "Formato de email inválido!")
    private String email;

    @NotBlank(message = "Senha é obrigatória!")
    private String password;

    private String role;

    @Enumerated(EnumType.STRING)
    private UserRole userROle;

    public User(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserRole getUserROle() {
        return userROle;
    }

    public void setUserROle(UserRole userROle) {
        this.userROle = userROle;
    }
}
