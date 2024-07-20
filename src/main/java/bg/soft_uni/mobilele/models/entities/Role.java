package bg.soft_uni.mobilele.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Column
    @Enumerated(EnumType.STRING)
    private RolesName name;
    public Role(RolesName rolesName){
        this.name=rolesName;
    }

    public Role() {

    }

    public RolesName getName() {
        return name;
    }

    public void setName(RolesName name) {
        this.name = name;
    }
}
