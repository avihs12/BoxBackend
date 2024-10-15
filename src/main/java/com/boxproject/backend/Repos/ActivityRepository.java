package com.boxproject.backend.Repos;

import com.boxproject.backend.Entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    @Query(value = "select * from Activity a where a.activity_city like CONCAT('%',:cityname,'%')", nativeQuery = true)
    List<Activity> findByNameContaining(@Param("cityname") String cityname);

    // @Query(value="select * from Activity a where a.activity_id like
    // CONCAT('%',:id,'%')",nativeQuery=true)
    // Activity findByActivity_id(@Param("id")Integer id);
    @Query(value = "select distinct a.activity_city from Activity a", nativeQuery = true)
    List<String> listofcities();

    @Query(value = "select distinct a.activity_name from Activity a where a.activity_city like :cityname", nativeQuery = true)
    List<String> activitiesinCity(@Param("cityname") String cityname);
}
