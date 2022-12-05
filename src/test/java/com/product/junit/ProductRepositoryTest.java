package com.product.junit;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.product.ProductServiceApplication;
import com.product.entity.AddressEntity;
import com.product.entity.CategoryEntity;
import com.product.entity.ContactEntity;
import com.product.entity.ManufactureEntity;
import com.product.entity.ProductEntity;
import com.product.entity.ProductTypeEntity;
import com.product.repository.CategoryRepository;
import com.product.repository.ProductRepository;
import com.product.repository.ProductTypeRepository;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = ProductServiceApplication.class)
public class ProductRepositoryTest {

	private ProductEntity productEntity;

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductTypeRepository productTypeRepository;

	@BeforeEach
	public void init() throws ParseException {
		MockitoAnnotations.openMocks(this);
		productEntity = new ProductEntity();
		productEntity.setProductGuid("jsehbfzsj");
		productEntity.setName("PENCIL");
		productEntity.setUnitPrice(10.00);
		productEntity.setUnitWeight(50.00);
		productEntity.setProductCode("123");

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateInString = "2021-12-25";
		Date date = new Date(newFormat.parse(dateInString).getTime());
		productEntity.setCreatedDate(date);

		productEntity.setCategoryEntity(new CategoryEntity(1, "stationary"));
		categoryRepository.save(new CategoryEntity(1, "stationary"));

		productEntity.setProductTypeEntity(new ProductTypeEntity(2, "0.5mm"));
		productTypeRepository.save(new ProductTypeEntity(2, "0.5mm"));

		ManufactureEntity manufactureEntity = new ManufactureEntity();
		manufactureEntity.setManufactureGuid("manu101");
		manufactureEntity.setManufactureCode("1001man");
		manufactureEntity.setCompanyName("TATA");

		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setAddressGuid("add121");
		addressEntity.setAddressLine1("102");
		addressEntity.setAddressLine2("2nd");
		addressEntity.setCity("hyd");
		addressEntity.setState("TS");
		addressEntity.setCountry("india");
		addressEntity.setPostalCode("500072");
		addressEntity.setManufacture(manufactureEntity);

		List<AddressEntity> listAddresses = new ArrayList<>();
		listAddresses.add(addressEntity);

		ContactEntity contactEntity = new ContactEntity();
		contactEntity.setContactGuid("cont1230");
		contactEntity.setValue("96215654");
		contactEntity.setManufacture(manufactureEntity);

		List<ContactEntity> listContacts = new ArrayList<>();
		listContacts.add(contactEntity);

		manufactureEntity.setAddressEntities(listAddresses);
		manufactureEntity.setContactEntities(listContacts);
		manufactureEntity.setProductEntity(productEntity);

		List<ManufactureEntity> manufactureEntities = new ArrayList<>();
		manufactureEntities.add(manufactureEntity);
		productEntity.setManufactureEntities(manufactureEntities);

	}

	@Order(0)
	@Test
	public void createProductTest() {
		ProductEntity entity1 = productRepository.save(productEntity);
		assertThat(entity1).isNotNull();
		assertThat(entity1.getProductGuid()).isNotEmpty();
	}

	@Order(1)
	@Test
	public void findByNames() {
		ProductEntity entity1 = productRepository.save(productEntity);
		List<ProductEntity> allProducts = productRepository.findByName("PENCIL");
		assertThat(allProducts.size()).isGreaterThanOrEqualTo(1);
	}

}
