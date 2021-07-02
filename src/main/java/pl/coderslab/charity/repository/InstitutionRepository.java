package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.entity.Institution;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
    @Query("SELECT i from Institution i")
    List<Institution> findAllInstitutions();

    @Query("select i from Institution i where i.id like ?1")
    Optional<Institution> findById(Long aLong);
}
