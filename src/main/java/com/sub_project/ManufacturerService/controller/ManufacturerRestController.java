package com.sub_project.ManufacturerService.controller;

import com.sub_project.ManufacturerService.VO.ResponseTemplateVO;
import com.sub_project.ManufacturerService.entity.Manufacturer;
import com.sub_project.ManufacturerService.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerRestController {
    @Autowired
    private ManufacturerService manufacturerService;
    @PostMapping("/")
    public Manufacturer saveManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerService.addManufacturer(manufacturer);
    }

    @PutMapping("/{id}")
    public Manufacturer updateManufacturer(@PathVariable("id") int id,@RequestBody Manufacturer manufacturer) {
        return manufacturerService.updateManufacturer(id, manufacturer);
    }

    @DeleteMapping("/{id}")
    public String deleteManufacturer(@PathVariable("id") int id) {
        try {
            manufacturerService.deleteManufacturer(id);
            return "Delete Success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/")
    public List<ResponseTemplateVO> getListManufactureWithPhone() {
        return manufacturerService.getListManufactureWithPhone();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getManufactureWithPhone(@PathVariable("id") int id) {
        return manufacturerService.getManufactureWithPhone(id);
    }
}
