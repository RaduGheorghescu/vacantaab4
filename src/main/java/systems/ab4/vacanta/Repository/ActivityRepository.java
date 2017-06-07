package systems.ab4.vacanta.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import systems.ab4.vacanta.Model.Activity;

import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long> {
    Activity findByActivityName(String activityName);
}
