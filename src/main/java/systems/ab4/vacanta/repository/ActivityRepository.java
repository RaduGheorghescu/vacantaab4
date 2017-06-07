package systems.ab4.vacanta.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import systems.ab4.vacanta.model.Activity;

/**
 * Created by radug on 6/7/2017.
 */
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long> {
    Activity findByActivityName(String activityName);
}
