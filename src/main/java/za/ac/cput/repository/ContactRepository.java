package za.ac.cput.repository;
// Mlungisi L. Mbuyazi
// 221164014
// https://github.com/Skiet88/comic__city_project

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
