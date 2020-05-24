package com.project.nairon.repository.advert;
/*
 *@author tobi
 * created on 18/05/2020
 *
 */

import com.project.nairon.models.advert.Location;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "locations", path = "locations")
public interface LocationRepository  extends PagingAndSortingRepository<Location, Integer> {
}
