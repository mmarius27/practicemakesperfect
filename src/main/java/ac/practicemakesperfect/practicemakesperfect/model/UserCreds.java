package ac.practicemakesperfect.practicemakesperfect.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "userCreds")
public class UserCreds implements UserDetails{
    @Id
    private String id;
    private String email;
    private String password;
    private String role;

    public UserCreds() {
        super();
    }

    public UserCreds(String email, String password){
        this.email = email;
        this.password = password;
        this.role = "";
    }

    public UserCreds(String email, String password, String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority e = new SimpleGrantedAuthority(role);
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        list.add(e);
        return list;
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