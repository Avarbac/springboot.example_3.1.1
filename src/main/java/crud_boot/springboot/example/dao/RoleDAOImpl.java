package crud_boot.springboot.example.dao;

import crud_boot.springboot.example.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Role> allRoles() {
        return manager.createQuery("FROM Role", Role.class)
                .getResultList();
    }

    @Override
    public Role findByRoleName(String role) {
        return manager.createQuery("select r from Role r where r.role =?1", Role.class)
                .setParameter(1, role)
                .getSingleResult();
    }

    @Override
    public Set<Role> getSetOfRoles(String[] roleNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roleNames) {
            roleSet.add(findByRoleName(role));
        }
        return roleSet;
    }
}
