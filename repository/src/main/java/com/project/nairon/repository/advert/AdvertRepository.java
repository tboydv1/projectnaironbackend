package com.project.nairon.repository.advert;

import com.project.nairon.models.advert.Advert;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author oluwatobi
 */

@RepositoryRestResource(collectionResourceRel = "adverts", path = "adverts")
public interface AdvertRepository extends PagingAndSortingRepository<Advert, Integer> {


}
