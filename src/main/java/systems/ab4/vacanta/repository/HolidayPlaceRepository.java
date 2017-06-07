package systems.ab4.vacanta.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import systems.ab4.vacanta.model.HolidayPlace;

import java.util.Date;

/**
 * Created by radug on 6/7/2017.
 */
public interface HolidayPlaceRepository extends PagingAndSortingRepository<HolidayPlace, Long> {
    Page<HolidayPlace> findByPlaceName(@Param("placeName") String placeName, Pageable page);
    @RestResource(rel = "findByActivityAndSortByAveragePriceASC",path = "/topPlaceForActivity")
    @Query(value = "select h from HolidayPlace h join h.activities a where a.activityName = :activityName order by h.averagePrice asc")
    Page<HolidayPlace> findByActivityAndSortByAveragePriceASC(@Param("activityName") String activityName, Pageable page);

    @Query(value = "select h from HolidayPlace h where h.startDate<:startDate and h.endDate>:endDate order by h.averagePrice asc")
    Page<HolidayPlace> findByDates(@Param("startDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date startDate, @Param("endDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date endDate, Pageable page);
}
