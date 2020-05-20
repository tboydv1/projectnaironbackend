package com.project.nairon.repository.advert;

import com.project.nairon.models.questionnaire.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
 *@author tobi
 * created on 18/05/2020
 *
 */
@RepositoryRestResource(collectionResourceRel = "devices", path = "devices")
public interface DeviceRepository extends PagingAndSortingRepository<Device, Integer> {

}
