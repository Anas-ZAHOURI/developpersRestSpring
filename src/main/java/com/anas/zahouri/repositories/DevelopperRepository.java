package com.anas.zahouri.repositories;

import com.anas.zahouri.model.Developper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevelopperRepository extends JpaRepository<Developper, Long> {

    Developper findById(long Id);

}
