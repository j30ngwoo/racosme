package com.hcellglobal.racosme.image;

import com.hcellglobal.racosme.image.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
}
