package com.codegym.dao.repository;

import com.codegym.dao.model.ViewCountStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViewCountStatisticRepository extends JpaRepository<ViewCountStatistic, Long> {
    @Query(value = "SELECT * FROM real_estate.view_count_statistic order by date_statistic desc limit 1",
            nativeQuery = true)
    ViewCountStatistic findLastViewCountStatistic();

    @Query(value = "select * from real_estate.view_count_statistic where date_statistic between ?1 and ?2",
            nativeQuery = true)
    List<ViewCountStatistic> getListViewCountStatistic(String startDay, String endDay);
}