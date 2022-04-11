package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.dto.request.ProductRequest;
import com.example.dto.request.ShopDTO;
import com.example.entity.Product;
import com.example.model.ProductDatatablesModel;

public interface ProductService {

	void createProduct(ProductRequest productRequest);
	
	void updateProduct(ProductRequest productRequest);
	
	void deleteProduct(Long id);
	
	List<Product> getAllProducts();
	
	ProductDatatablesModel getProductDatatablesModel();
	
	Product getProductById(ProductRequest productRequest);
	List<ShopDTO> getProductByPage(Integer pageNumber, Integer pageSize);
	
	List<ShopDTO> getSortedProductByPage(Integer pageNumber, Integer pageSize, String sort, String strademark, String idCourtyard);
	
	List<ShopDTO> getFoundedProductByPage(Integer pageNumber, Integer pageSize, String strademark, String idCourtyard);

	List<ShopDTO> getShowProducts(List<ShopDTO> listProduct);
	
	 int getNumberOfPage(int pageSize, String strademark, String idCourtyard);
	
	List<ShopDTO> getCustomProduct();
	
	Product getProductById(Long id);
	
	List<Product> getGroupProducts(String name, Long id );
	
	List<ShopDTO> productFound(String keyword, Integer pageNumber, Integer pageSize);

	int getNumberOfPage2(Integer pageSize, String keyword);
	
	List<ShopDTO> getReferenceProducts(String strademark);
	
	List<ShopDTO> getPopularProduct();
	
	List<ShopDTO> getLastestProduct();
	
	List<ShopDTO> getSortOnTimeProduct(Integer pageNumber, Integer pageSize,String key);
}
