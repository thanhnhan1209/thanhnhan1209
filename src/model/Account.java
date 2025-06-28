package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Column(name = "fullName")
    private String fullName;

    @Id
    @Column(name = "userName")
    private String user;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private int status;

    @Column(name = "email")
    private String email;

    public Account() {}

    public Account(String fullName, String user, String password, String role, int status, String email) {
        this.fullName = fullName;
        this.user = user;
        this.password = password;
        this.role = role;
        this.status = status;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, user, password, role, status, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account other = (Account) obj;
        return status == other.status &&
                Objects.equals(fullName, other.fullName) &&
                Objects.equals(user, other.user) &&
                Objects.equals(password, other.password) &&
                Objects.equals(role, other.role) &&
                Objects.equals(email, other.email);
    }

    @Override
    public String toString() {
        return "Account{" +
                "fullName='" + fullName + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                '}';
    }
}
