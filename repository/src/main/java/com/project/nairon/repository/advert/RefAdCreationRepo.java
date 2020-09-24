package com.project.nairon.repository.advert;

import com.project.nairon.models.reference.RefAdsCreation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
 *@author tobi
 * created on 18/05/2020
 *
 */
@RepositoryRestResource(collectionResourceRel = "ref_data", path = "ref_data")
public interface RefAdCreationRepo extends PagingAndSortingRepository<RefAdsCreation, Integer> {

}
