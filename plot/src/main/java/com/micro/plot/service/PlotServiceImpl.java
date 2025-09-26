package com.micro.plot.service;

import com.micro.plot.config.PlotConfiguration;
import com.micro.plot.dto.PlotDto;
import com.micro.plot.entities.Plot;
import com.micro.plot.exception.ResourceNotFoundException;
import com.micro.plot.payload.ApiResponse;
import com.micro.plot.repository.PlotRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PlotServiceImpl implements PlotService {
    private final PlotRepository plotRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponse<Plot> savePlot(PlotDto plotDto) {
        Plot plot = modelMapper.map(plotDto, Plot.class);
        plot.setId(UUID.randomUUID().toString());
        plot.setDateTime(LocalDateTime.now().toString());
        Plot savedPlot = plotRepository.save(plot);
        return new ApiResponse<>("success", "plot saved successfully", savedPlot);
    }

    @Override
    public ApiResponse<List<Plot>> findAllPlot() {
        List<Plot> all = plotRepository.findAll();

        if (all.isEmpty()) {
            return new ApiResponse<>("Success", "No Plot Found", null);
        }
        return new ApiResponse<>("Success", "Plot Found", all);

    }

    @Override
    public ApiResponse<Plot> findSinglePlot(String id) {
        Plot plot = plotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("plot not found"));
        return new ApiResponse<>("Sucess", "Data Found", plot);
    }
}
