package com.sub_project.ManufacturerService.service;

import com.sub_project.ManufacturerService.VO.ResponseTemplateVO;
import com.sub_project.ManufacturerService.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {

    Manufacturer addManufacturer(Manufacturer manufacturer);

    Manufacturer updateManufacturer(int id, Manufacturer manufacturer);

    void deleteManufacturer(int id);

    List<ResponseTemplateVO> getListManufactureWithPhone();

    ResponseTemplateVO getManufactureWithPhone(int id);
}
