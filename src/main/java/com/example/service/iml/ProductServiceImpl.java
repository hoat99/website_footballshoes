package com.example.service.iml;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.aspectj.weaver.ast.And;
import org.dom4j.Branch;
import org.springframework.stereotype.Service;

import com.example.common.FileUtils;
import com.example.dto.request.ProductRequest;
import com.example.dto.request.ShopDTO;
import com.example.dto.request.StrademarkDTO;
import com.example.entity.Banner;
import com.example.entity.Courtyard;
import com.example.entity.Image;
import com.example.entity.Product;
import com.example.entity.Strademark;
import com.example.model.ProductDatatablesModel;
import com.example.repository.CourtyardRepository;
import com.example.repository.ImageRepository;
import com.example.repository.ProductRespository;
import com.example.repository.StrademarkRepository;
import com.example.service.ProductService;

import ch.qos.logback.core.joran.conditional.IfAction;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private final EntityManager entityManager;
	
	private final ProductRespository productRespository;
	
	private final StrademarkRepository strademarkRepository;
	
	private final CourtyardRepository courtyardRepository;
	
	private final ImageRepository imageRepository;
	@Override
	public void createProduct(ProductRequest productRequest) {
		Optional<Strademark> strademark = this.strademarkRepository.findById(productRequest.getIdStrademark());
		Optional<Courtyard> courtyard = this.courtyardRepository.findById(productRequest.getIdCourtyard());
		Optional<Image> image = this.imageRepository.findByNameProduct(productRequest.getImgProduct());

		Product product = new Product();
		
		product.setAlbum(productRequest.getAlbum());
		product.setName(productRequest.getName());
		product.setCost(productRequest.getCost());
		product.setQuantity(productRequest.getQuantity());
		product.setMaterial(productRequest.getMaterial());
		product.setRepresentativePlayer(productRequest.getRepresentativePlayer());
		product.setYearOfProduction(productRequest.getYearOfProduction());
		product.setTechnology(productRequest.getTechnology());
		strademark.ifPresent(product::setStrademark);
		courtyard.ifPresent(product::setCourtyard);
		image.ifPresent(product::setImage);
		product.setColor(productRequest.getColor());
		product.setSize(productRequest.getSize());
		System.out.println(product);
		this.productRespository.save(product);
	}

	private StrademarkDTO stradeMapper(Strademark strademark) {
		return StrademarkDTO.builder()
				.id(strademark.getIdStrademark()).name(strademark.getName())
				.img(strademark.getImg())
				.build();
	}
	
	@Override
	public void updateProduct(ProductRequest productRequest) {
		Optional<Product> prodOptional = this.productRespository.findById(productRequest.getIdProduct());	
		Product product = prodOptional.get();
		product.setName(productRequest.getName());
		product.setCost(productRequest.getCost());
		product.setQuantity(productRequest.getQuantity());
		product.setSize(productRequest.getSize());
		product.setColor(productRequest.getColor());
		if (productRequest.getIdStrademark() != null) {
			Optional<Strademark> strademark = this.strademarkRepository.findById(productRequest.getIdStrademark());
			strademark.ifPresent(product::setStrademark);
		}
		if (productRequest.getIdCourtyard() != null) {
			Optional<Courtyard> courtyard = this.courtyardRepository.findById(productRequest.getIdCourtyard());
			courtyard.ifPresent(product::setCourtyard);
		}
		product.setMaterial(productRequest.getMaterial());
		product.setRepresentativePlayer(productRequest.getRepresentativePlayer());
		product.setTechnology(productRequest.getTechnology());
		product.setAlbum(productRequest.getAlbum());
		if (productRequest.getYearOfProduction() != null) {
			product.setYearOfProduction(productRequest.getYearOfProduction());
		}
		if (productRequest.getImgProduct() != null) {
			Optional<Image> image = this.imageRepository.findByNameProduct(productRequest.getImgProduct());
			image.ifPresent(product::setImage);
		}	
		this.productRespository.save(product);
		
	}

	@Override
	public void deleteProduct(Long id) {
		this.productRespository.deleteById(id);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return this.productRespository.findAll();
	}

	@Override
	public Product getProductById(ProductRequest productRequest) {
		Product product = entityManager.find(Product.class, productRequest.getIdProduct());
		return product;
	}

	public List<ShopDTO> getProductByPage(Integer pageNumber, Integer pageSize) {
		TypedQuery<ShopDTO> query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost , p.rate, p.costDiscount, p.isDiscount) from Product p", ShopDTO.class);
		int position = pageNumber * pageSize;
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
	
	
	
	@Override
	public List<ShopDTO> getCustomProduct() {
		TypedQuery<ShopDTO> query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p order by p.idProduct", ShopDTO.class);
		return query.getResultList();
	}

	@Override
	public Product getProductById(Long id) {		
		return this.entityManager.find(Product.class, id);
	}

	@Override
	public List<Product> getGroupProducts(String name, Long id) {
		Product product = getProductById(id);	
		return this.productRespository.getGroupProduct(product.getName());
	}

	@Override
	public List<ShopDTO> productFound(String keyword, Integer pageNumber, Integer pageSize) {	
		TypedQuery<ShopDTO> query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p where p.nameRemovedAccent like :keyword", ShopDTO.class);
		query.setParameter("keyword", keyword);
		int position = pageNumber * pageSize;
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getNumberOfPage2(Integer pageSize, String keyword) {
		TypedQuery<Long> countProductQuery = entityManager.createQuery("select count(p.id) from Product p where p.nameRemovedAccent like :keyword", Long.class);
		countProductQuery.setParameter("keyword", keyword);
		Long countPerson = countProductQuery.getSingleResult();
		return (int) Math.ceil(Double.valueOf(countPerson) / Double.valueOf(pageSize));
	}

	@Override
	public List<ShopDTO> getSortedProductByPage(Integer pageNumber, Integer pageSize, String sort, String strademark, String idCourtyard) {
		TypedQuery<ShopDTO> query = null;
		if (sort == "lowToHigh") {
			query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p where p.strademark.name like :strademark and p.courtyard.type like :idCourtyard order by p.cost", ShopDTO.class);
		}else {
			query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p where p.strademark.name like :strademark and p.courtyard.type like :idCourtyard order by p.cost DESC", ShopDTO.class);
		}
		query.setParameter("strademark", strademark);
		query.setParameter("idCourtyard", idCourtyard);
		int position = pageNumber * pageSize;
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public List<ShopDTO> getFoundedProductByPage(Integer pageNumber, Integer pageSize, String strademark, String idCourtyard) {
		TypedQuery<ShopDTO> query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p where p.strademark.name like :strademark and p.courtyard.type like :idCourtyard", ShopDTO.class);
		query.setParameter("strademark", strademark);
		query.setParameter("idCourtyard", idCourtyard);
		int position = pageNumber * pageSize;
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}

	@Override
	public int getNumberOfPage(int pageSize, String strademark, String idCourtyard) {
			TypedQuery<Long> countProductQuery = entityManager.createQuery("select count(p.id) from Product p where p.strademark.name like :strademark and p.courtyard.type like :idCourtyard", Long.class);
			countProductQuery.setParameter("strademark", strademark);
			countProductQuery.setParameter("idCourtyard", idCourtyard);
			Long countProduct = countProductQuery.getSingleResult();
			return (int) Math.ceil(Double.valueOf(countProduct) / Double.valueOf(pageSize));		
	}

	@Override
	public List<ShopDTO> getShowProducts(List<ShopDTO> listProduct) {
		List<ShopDTO> list = new ArrayList<>();
		List<String> name = new ArrayList<>();
		for (int i = 0; i < listProduct.size(); i++) {
			boolean flag = false;
			ShopDTO product = listProduct.get(i);
			
			for (int j = 0; j < name.size(); j++) {
				if (product.getName().compareTo(name.get(j)) == 0) {
					flag = true;
					break;
				}	
			}
			
			if (flag == false) {
				list.add(product);
				name.add(product.getName());
			}	
		}
		return list;
	}

	@Override
	public List<ShopDTO> getReferenceProducts(String strademark) {
		TypedQuery<ShopDTO> query = this.entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p where p.strademark.name like :strademark", ShopDTO.class);
		query.setParameter("strademark", strademark);
		return query.getResultList();
	}

	@Override
	public ProductDatatablesModel getProductDatatablesModel() {
		return ProductDatatablesModel.converter(this.productRespository.findAll());
	}

	@Override
	public List<ShopDTO> getPopularProduct() {
		TypedQuery<ShopDTO> query = this.entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p ORDER BY p.rate desc", ShopDTO.class);
		List<ShopDTO> list = getShowProducts(query.getResultList());
		if (list.size()>=6) {
			return list.subList(0, 6);
		}else {
			return list;
		}
	}

	@Override
	public List<ShopDTO> getLastestProduct() {
		TypedQuery<ShopDTO> query = this.entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p ORDER BY p.createAt desc", ShopDTO.class);
		List<ShopDTO> list = getShowProducts(query.getResultList());	
		if (list.size()>=6) {
			return list.subList(0, 6);
		}else {
			return list;
		}
	}

	@Override
	public List<ShopDTO> getSortOnTimeProduct(Integer pageNumber, Integer pageSize,String key) {
		TypedQuery<ShopDTO> query = null;
		if (key == "lastest") {
			query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p ORDER BY p.createAt desc", ShopDTO.class);
		}else {
			query = entityManager.createQuery("select new com.example.dto.request.ShopDTO(p.idProduct, p.name,p.image.avatar, p.cost, p.rate, p.costDiscount, p.isDiscount) from Product p ORDER BY p.createAt asc", ShopDTO.class);
		}
		
		int position = pageNumber * pageSize;
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		return query.getResultList();
	}
	
//	@PostConstruct
//	public void abc() {
//		List<Product> products = this.productRespository.findAll();
//		for (Product product : products) {
//			product.setIsDiscount(false);
//			productRespository.save(product);
//		}
//		
//	}
}
