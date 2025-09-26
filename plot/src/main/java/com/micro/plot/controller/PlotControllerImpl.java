package com.micro.plot.controller;
import com.micro.plot.dto.PlotDto;
import com.micro.plot.entities.Plot;
import com.micro.plot.payload.ApiResponse;
import com.micro.plot.service.PlotServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/plot")
@RequiredArgsConstructor
public class PlotControllerImpl {
    private  final PlotServiceImpl plotServiceimpl;
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Plot>> singPlot(@PathVariable  String id){
        ApiResponse<Plot> singlePlot = plotServiceimpl.findSinglePlot(id);
        return  ResponseEntity.status(HttpStatus.OK).body(singlePlot);
    }
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Plot>>> getAllPlot(){
        ApiResponse<List<Plot>> allPlot = plotServiceimpl.findAllPlot();
        return ResponseEntity.status(HttpStatus.OK).body(allPlot);
    }
@PostMapping("/save")
    public  ResponseEntity<ApiResponse<Plot>>  savePlot(@Valid @RequestBody PlotDto plotDto){
        ApiResponse<Plot> plotApiResponse = plotServiceimpl.savePlot(plotDto);
        return ResponseEntity.status(HttpStatus.OK).body(plotApiResponse);
    }
}
