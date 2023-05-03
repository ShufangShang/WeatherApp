/* package com.tts.weatherapp.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tts.weatherapp.domain.ZipCode; 
 */
import java.util.List;

@Repository
public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {

    //List<ZipCode> findById(Long id);
    List<ZipCode> findFirst10ByOrderByIdDesc();
}
