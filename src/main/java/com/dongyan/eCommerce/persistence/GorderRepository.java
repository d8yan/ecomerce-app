package com.dongyan.eCommerce.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GorderRepository extends JpaRepository<Gorder,Long> {
}
