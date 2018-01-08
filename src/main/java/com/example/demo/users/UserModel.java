package com.example.demo.users;

import com.example.demo.security.jwt.TokenUtils;
import com.example.demo.tenant.TenantModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class UserModel implements UserDetails,Cloneable,Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String level;

    String login;

    String password;

    @OneToOne
    TenantModel tenantModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public TenantModel getTenantModel() {
        return tenantModel;
    }

    public void setTenantModel(TenantModel tenantModel) {
        this.tenantModel = tenantModel;
    }

    public String getPassword() {
        System.out.println("GET PASSWORD  " + password);
        return password;
    }

    public String getUsername() {
        System.out.println("GET USERNAME  " + login);
        return login;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = TokenUtils.passwordEncoder.encode(password);
    }

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {

        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        System.out.println("getAuthorities init for");


        return grantedAuthorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
