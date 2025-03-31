package in.kanhajava.organizationservice.repository;

import in.kanhajava.organizationservice.entiry.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByorganizationCode(String code);
}
