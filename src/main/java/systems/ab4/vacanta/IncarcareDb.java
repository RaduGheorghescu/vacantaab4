package systems.ab4.vacanta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import systems.ab4.vacanta.model.*;
import systems.ab4.vacanta.repository.ActivityRepository;
import systems.ab4.vacanta.repository.CountryRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by radug on 6/7/2017.
 */
@Component
public class IncarcareDb implements ApplicationRunner{

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        String[] actList = {
                "swim",
                "dance",
                "expeditions",
                "skiing"
        };

        String myDate = "23/06/2018";
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = date.parse(myDate);
        myDate = "23/10/2018";
        Date endDate = date.parse(myDate);

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("swim"));
        activities.add(new Activity("dance"));
        activities.add(new Activity("expeditions"));
        activities.add(new Activity("skiing"));
        activityRepository.save(activities);
        List<Country> countries = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0,40)
                .forEach(i ->{
                    Country country = new Country("Country"+i);
                    IntStream.range(0,3)
                            .forEach(j -> {
                                County county = new County(country.getCountryName()+" - County"+j);
                                country.addCounty(county);
                                    IntStream.range(0, 20)
                                            .forEach(k ->{
                                                City city = new City("City"+k);
                                                county.addCity(city);
                                                IntStream.range(0,10)
                                                        .forEach(l ->{
                                                            HolidayPlace holidayPlace = new HolidayPlace(city.getCityName()+" - Holiday"+l, 100 + 200 * random.nextDouble(), startDate, endDate);
                                                            city.addHolidayPlace(holidayPlace);
                                                            IntStream.range(0,2)
                                                                    .forEach(m ->{
                                                                        holidayPlace.addActivity(activityRepository.findByActivityName(actList[random.nextInt(3)]));
                                                                    });
                                                        });
                                            });
                            });
                    countries.add(country);
                });
        countryRepository.save(countries);
    }
}
