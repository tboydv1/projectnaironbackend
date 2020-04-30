package com.project.nairon.repository.advert;

import com.project.nairon.models.advert.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author oluwatobi
 */

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Integer> {


}
