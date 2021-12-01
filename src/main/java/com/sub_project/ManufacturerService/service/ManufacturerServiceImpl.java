package com.sub_project.ManufacturerService.service;

import com.sub_project.ManufacturerService.VO.Phone;
import com.sub_project.ManufacturerService.VO.ResponseTemplateVO;
import com.sub_project.ManufacturerService.entity.Manufacturer;
import com.sub_project.ManufacturerService.repository.ManufacturerRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService{
    @Autowired
    private ManufacturerRepositoty manufacturerRepositoty;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
         manufacturerRepositoty.save(manufacturer);
        return manufacturer;
    }

    @Override
    public Manufacturer updateManufacturer(int id, Manufacturer manufacturer) {
        manufacturer.setId(id);
        manufacturerRepositoty.save(manufacturer);
        return manufacturer;
    }

    @Override
    public void deleteManufacturer(int id) {
        manufacturerRepositoty.deleteById(id);

    }

    @Override
    public List<ResponseTemplateVO> getListManufactureWithPhone() {
        ArrayList<ResponseTemplateVO> listResponseTemplateVO = new ArrayList<>();
        ArrayList<Manufacturer> listManufacturer = (ArrayList<Manufacturer>) manufacturerRepositoty.findAll();
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        for (int i = 0; i < listManufacturer.size(); i++) {
            responseTemplateVO.setManufacturer(listManufacturer.get(i));
            responseTemplateVO.setPhone(restTemplate.getForObject("http://localhost:8080/phones/" + listManufacturer.get(i).getPhoneId(), Phone.class));
            listResponseTemplateVO.add(responseTemplateVO);
        }
        return listResponseTemplateVO;
    }

    @Override
    public ResponseTemplateVO getManufactureWithPhone(int id) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Manufacturer manufacturer = manufacturerRepositoty.findById(id).get();
        responseTemplateVO.setManufacturer(manufacturer);
        Phone phone = restTemplate.getForObject("http://localhost:8080/phones/" + manufacturer.getPhoneId(),
                Phone.class);
        responseTemplateVO.setPhone(phone);
        return responseTemplateVO;
    }
}
