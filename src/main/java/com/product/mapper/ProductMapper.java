package com.product.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.product.entity.AddressEntity;
import com.product.entity.CategoryEntity;
import com.product.entity.ContactEntity;
import com.product.entity.ManufactureEntity;
import com.product.entity.PatentEntity;
import com.product.entity.ProductEntity;
import com.product.entity.ProductTypeEntity;
import com.product.model.AddressModel;
import com.product.model.CategoryModel;
import com.product.model.ContactModel;
import com.product.model.ManufactureModel;
import com.product.model.PatentModel;
import com.product.model.ProductModel;
import com.product.model.ProductTypeModel;

@Component
public class ProductMapper {
	public ProductEntity modelToProductEntity(ProductModel productModel) {
		ProductEntity productEntity = new ProductEntity();
		BeanUtils.copyProperties(productModel, productEntity);
		productEntity
				.setManufactureEntities(modelToManufactureEntity(productEntity, productModel.getManufactureModels()));
		productEntity.setCategoryEntity(modelToCategoryEntity(productModel.getCategoryModel()));
		if (productModel.getPatentModels() != null) {
			productEntity.setPatentEntities(modelToPatentEntity(productEntity, productModel.getPatentModels()));
		}
		productEntity.setProductTypeEntity(modelToProductTypeEntity(productEntity, productModel.getProductTypeModel()));

		return productEntity;
	}

	private List<ManufactureEntity> modelToManufactureEntity(ProductEntity productEntity,
			List<ManufactureModel> manufactureModels) {
		List<ManufactureEntity> manufactureEntities = new ArrayList<>();
		for (ManufactureModel manufactureModel : manufactureModels) {
			ManufactureEntity manufactureEntity = new ManufactureEntity();
			BeanUtils.copyProperties(manufactureModel, manufactureEntity);
			manufactureEntity.setManufactureGuid(UUID.randomUUID().toString());
			manufactureEntity.setProductEntity(productEntity);
			manufactureEntity
					.setAddressEntities(modelToAddressEntities(manufactureEntity, manufactureModel.getAddressModels()));
			manufactureEntity
					.setContactEntities(modelTOContactEntity(manufactureEntity, manufactureModel.getContactModels()));
			manufactureEntities.add(manufactureEntity);
		}
		return manufactureEntities;

	}

	public List<AddressEntity> modelToAddressEntities(ManufactureEntity manufactureEntity,
			List<AddressModel> addressModels) {
		List<AddressEntity> addressEntities = new ArrayList<>();
		for (AddressModel addressModel : addressModels) {
			System.out.println("addressModel.getLine1---->" + addressModel);
			AddressEntity addressEntity = new AddressEntity();
			BeanUtils.copyProperties(addressModel, addressEntity);
			addressEntity.setAddressGuid(UUID.randomUUID().toString());
			addressEntity.setManufacture(manufactureEntity);
			addressEntities.add(addressEntity);
		}
		return addressEntities;

	}

	public List<ContactEntity> modelTOContactEntity(ManufactureEntity manufactureEntity,
			List<ContactModel> contactModels) {
		List<ContactEntity> contactEntities = new ArrayList<>();
		for (ContactModel contactModel : contactModels) {
			ContactEntity contactEntity = new ContactEntity();
			BeanUtils.copyProperties(contactModel, contactEntity);
			contactEntity.setContactGuid(UUID.randomUUID().toString());
			contactEntity.setManufacture(manufactureEntity);
			contactEntities.add(contactEntity);
		}
		return contactEntities;

	}

	public CategoryEntity modelToCategoryEntity(CategoryModel categoryModel) {
		CategoryEntity categoryEntity = new CategoryEntity();
		BeanUtils.copyProperties(categoryModel, categoryEntity);
		return categoryEntity;
	}

	private List<PatentEntity> modelToPatentEntity(ProductEntity productEntity, List<PatentModel> patentModels) {
		List<PatentEntity> patentEntities = new ArrayList<>();

		for (PatentModel patentModel : patentModels) {
			PatentEntity patentEntity = new PatentEntity();
			BeanUtils.copyProperties(patentModel, patentEntity);
			patentEntity.setProductEntity(productEntity);
			patentEntities.add(patentEntity);
		}
		return patentEntities;

	}

	public ProductTypeEntity modelToProductTypeEntity(ProductEntity productEntity, ProductTypeModel productTypeModel) {
		ProductTypeEntity productTypeEntity = new ProductTypeEntity();
		BeanUtils.copyProperties(productTypeModel, productTypeEntity);
		return productTypeEntity;
	}

	public List<ProductModel> entitiesToProductModel(List<ProductEntity> productEntities) {
		List<ProductModel> productModels = new ArrayList<>();
		for (ProductEntity productEntity : productEntities) {
			ProductModel productModel = entityToProductModel(productEntity);
			productModels.add(productModel);
		}
		return productModels;
	}

	public ProductModel entityToProductModel(ProductEntity productEntity) {
		ProductModel productModel = new ProductModel();
		BeanUtils.copyProperties(productEntity, productModel);
		productModel.setManufactureModels(entityToManufactureModel(productEntity.getManufactureEntities()));
		productModel.setCategoryModel(entityToCategoryModel(productEntity.getCategoryEntity()));
		productModel.setPatentModels(entityToPatentModel(productEntity.getPatentEntities()));
		productModel.setProductTypeModel(entityToProductTypeModel(productEntity.getProductTypeEntity()));

		return productModel;
	}

	public List<ManufactureModel> entityToManufactureModel(List<ManufactureEntity> manufactureEntities) {
		List<ManufactureModel> manufactureModels = new ArrayList<>();
		for (ManufactureEntity manufactureEntity : manufactureEntities) {
			ManufactureModel manufactureModel = new ManufactureModel();
			BeanUtils.copyProperties(manufactureEntity, manufactureModel);
			manufactureModel.setAddressModels(entityToAddressModel(manufactureEntity.getAddressEntities()));
			manufactureModel.setContactModels(entityToContactModel(manufactureEntity.getContactEntities()));
			manufactureModels.add(manufactureModel);
		}
		return manufactureModels;
	}

	public List<AddressModel> entityToAddressModel(List<AddressEntity> addressEntities) {
		List<AddressModel> addressModels = new ArrayList<>();
		for (AddressEntity addressEntity : addressEntities) {
			AddressModel addressModel = new AddressModel();
			BeanUtils.copyProperties(addressEntity, addressModel);
			addressModels.add(addressModel);
		}
		return addressModels;
	}

	public List<ContactModel> entityToContactModel(List<ContactEntity> contactEntities) {
		List<ContactModel> contactModels = new ArrayList<>();
		for (ContactEntity contactEntity : contactEntities) {
			ContactModel contactModel = new ContactModel();
			BeanUtils.copyProperties(contactEntity, contactModel);
			contactModels.add(contactModel);
		}
		return contactModels;
	}

	public CategoryModel entityToCategoryModel(CategoryEntity categoryEntity) {
		CategoryModel categoryModel = new CategoryModel();
		BeanUtils.copyProperties(categoryEntity, categoryModel);

		return categoryModel;
	}

	public List<PatentModel> entityToPatentModel(List<PatentEntity> patentEntities) {
		List<PatentModel> patentModels = new ArrayList<>();
		for (PatentEntity patentEntity : patentEntities) {
			PatentModel patentModel = new PatentModel();
			BeanUtils.copyProperties(patentEntity, patentModel);
			patentModels.add(patentModel);
		}
		return patentModels;
	}

	public ProductTypeModel entityToProductTypeModel(ProductTypeEntity productTypeEntity) {
		ProductTypeModel productTypeModel = new ProductTypeModel();
		BeanUtils.copyProperties(productTypeEntity, productTypeModel);

		return productTypeModel;
	}
}