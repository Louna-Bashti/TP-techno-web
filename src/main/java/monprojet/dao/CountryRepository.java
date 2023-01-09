package monprojet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query(value = "SELECT SUM(population) " + " FROM City " + " WHERE Country_id = :identifiant ", nativeQuery = true)
    int populationDuPays(Integer identifiant);

    @Query(value = "SELECT Country.nom AS name, SUM(CITY.population) AS pop FROM Country INNER JOIN City ON (Country.id = City.Country_id) GROUP BY Country.nom ", nativeQuery = true)
    List<PopulationCountry> countryNameAndPop();



}
