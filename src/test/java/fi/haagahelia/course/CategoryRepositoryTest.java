/*
package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

	 @Autowired
	    private CategoryRepository crepository;
	
	
    
    @Test
    public void findBynameShouldReturnCategory() {
        List<Category> categories = crepository.findByName("Kauhu");
        
        assertThat(categories).hasSize(1);
    
    }
  

}


*/