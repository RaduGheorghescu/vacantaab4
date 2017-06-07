package systems.ab4.vacanta.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import systems.ab4.vacanta.Model.City;
import systems.ab4.vacanta.Model.HolidayPlace;

import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

}
