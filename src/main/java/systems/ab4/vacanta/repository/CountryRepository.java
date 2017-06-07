package systems.ab4.vacanta.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import systems.ab4.vacanta.model.Country;

/**
 * Created by radug on 6/7/2017.
 */
@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country,Long>{

}
