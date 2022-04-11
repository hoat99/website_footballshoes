package com.example.service.iml;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.request.CreateImportGoodsRequest;
import com.example.entity.Cthdn;
import com.example.entity.CthdnId;
import com.example.entity.HoaDonNhap;
import com.example.model.HoaDonNhapDatatablesModel;
import com.example.repository.CthdnRepository;
import com.example.repository.HoaDonNhapRepository;
import com.example.repository.SupplierRepository;
import com.example.service.ImportGoodsService;

@Service
@RequiredArgsConstructor
public class ImportGoodsServiceImpl implements ImportGoodsService{
	
	private final HoaDonNhapRepository hoaDonNhapRepository;
	
	private final CthdnRepository cthdnRepository;
	
	private final SupplierRepository supplierRepository;
	
	@Override
	public void createGoodsReceived(CreateImportGoodsRequest createImportGoodsRequest) {
		HoaDonNhap hoaDonNhap = new HoaDonNhap();
		hoaDonNhap.setSupplier(this.supplierRepository.getById(createImportGoodsRequest.getIdSupplier()));
		hoaDonNhapRepository.save(hoaDonNhap);
		
		List<Long> idProducts = createImportGoodsRequest.getIdProduct();
		List<Integer> quantitys = createImportGoodsRequest.getQuantity();
		
		for (int i = 0; i < idProducts.size(); i++) {
			Cthdn cthdn = new Cthdn();
			CthdnId cthdnId = new CthdnId();
			cthdnId.setHoaDonNhapId(hoaDonNhap.getId());
			cthdnId.setProductId(idProducts.get(i));
			cthdn.setId(cthdnId);
			cthdn.setQuantity(quantitys.get(i));
			cthdnRepository.save(cthdn);
		}
	}

	@Override
	public HoaDonNhapDatatablesModel getHoaDonNhapDatatablesModel() {
		return HoaDonNhapDatatablesModel.converter(this.hoaDonNhapRepository.findAll());
	}

	@Transactional
	@Override
	public void deleteCthdnAndHoaDonNhap(Long id) {
		this.hoaDonNhapRepository.deleteById(id);
		this.cthdnRepository.deleteByHoaDonNhapId(id);
	}

}
