package systems.ab4.vacanta.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radug on 6/7/2017.
 */
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String countryName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<County> counties;

    public Country() {
        counties = new ArrayList<>();
    }

    public Country(String countryName) {
        this();
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<County> getCounties() {
        return counties;
    }

    public void addCounty(County county) {
        county.setCountry(this);
        counties.add(county);
    }
}
