package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.model.entity.Role;
import pl.coderslab.charity.repository.RoleRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl  {

    @Autowired
    private final RoleRepository repository;

    public Role findRoleByName(String name) {
        return repository.findByName(name);
    }
}
