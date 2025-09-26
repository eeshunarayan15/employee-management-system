package com.micro.plot.service;

import com.micro.plot.dto.PlotDto;
import com.micro.plot.entities.Plot;
import com.micro.plot.payload.ApiResponse;

import java.util.List;
public interface PlotService {
ApiResponse<Plot> savePlot(PlotDto plotDto);
   ApiResponse<List<Plot>> findAllPlot();
   ApiResponse<Plot> findSinglePlot(String id);
}
