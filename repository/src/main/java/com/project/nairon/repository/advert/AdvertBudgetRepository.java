package com.project.nairon.repository.advert;

import com.project.nairon.models.advert.AdvertBudget;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author oluwatobi
 */

@RepositoryRestResource(collectionResourceRel = "budgets", path = "budgets ", exported = false)
public interface AdvertBudgetRepository extends PagingAndSortingRepository<AdvertBudget, Integer> {
}
