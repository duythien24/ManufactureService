package com.sub_project.ManufacturerService.VO;

import com.sub_project.ManufacturerService.entity.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Phone phone;
    private Manufacturer manufacturer;
}
