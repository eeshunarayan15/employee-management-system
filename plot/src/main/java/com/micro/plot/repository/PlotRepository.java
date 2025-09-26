package com.micro.plot.repository;
import com.micro.plot.entities.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlotRepository extends JpaRepository<Plot,String> {
}
