package com.micro.plot.controller;

import com.micro.plot.entities.Plot;
import org.springframework.http.ResponseEntity;

public interface PlotController {
    String getPlotById(Long id);
    String getAllPlot();
  ResponseEntity<Plot> savePlot();
}
