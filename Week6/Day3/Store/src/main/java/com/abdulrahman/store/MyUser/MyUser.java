package com.abdulrahman.store.MyUser;

import com.abdulrahman.store.Order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Data

public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Pattern(regexp = "^USER$",message = "Role must be user only")
    @Column(columnDefinition = "varchar(10) not null check (role='USER' || role='ADMIN' )")
    private String role;
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Set<Order> userOrders;

    public void emptyBlogs(){
        this.userOrders.clear();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
