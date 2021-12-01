package com.sub_project.ManufacturerService.repository;

import com.sub_project.ManufacturerService.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepositoty extends JpaRepository<Manufacturer, Integer> {
}
