package com.tts.weatherapp.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.tts.weatherapp.domain.ZipCode;

public interface MyZipCodeRepository  extends CrudRepository<ZipCode, Long> {

    //List<ZipCode> findById(Long id);
    //List<ZipCode> findFirst10ByOrderByIdDesc();

    /* @Query("SELECT zipcode from zip_code order by id desc")
    List<String> findAllByID();
 */
    /* 
    @Query("SELECT DISTINCT p.brand FROM Product p")
    List<String> findDistinctBrands(); */

    /* @Query("SELECT top 10 codes.zipcode FROM ZIP_CODE codes order by ID Desc")
    List<ZipCode> findTop10ZipcodesOrderByIDDes();
 */
}
