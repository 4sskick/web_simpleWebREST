package com.niteroomcreation.simplewebrest.models.data.domains;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by monta on 15/12/20
 * please make sure to use credit when you're using people's code
 */

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long Id;
    private String name;

    @OneToMany(targetEntity = User.class, mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<User> users;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }

}
