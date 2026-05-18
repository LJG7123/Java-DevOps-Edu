package web.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorCode;
import web.mvc.exception.MyErrorException;

@RequiredArgsConstructor
@Repository
public class ProductDAOImpl implements ProductDAO {

	private final List<ProductDTO> productList;

	@Override
	public List<ProductDTO> select() {
		return productList;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		if (selectByCode(productDTO.getCode()) != null)
			throw new MyErrorException(ErrorCode.DUPLICATE_PRODUCT_CODE);

		return productList.add(productDTO) ? 1 : 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		boolean isDeleted = productList.removeIf((p) -> code.equals(p.getCode()));
		if (!isDeleted) throw new MyErrorException(ErrorCode.INVALID_PRODUCT_CODE);
		
		return isDeleted ? 1 : 0;
	}

	@Override
	public ProductDTO selectByCode(String code) {
		for (ProductDTO p: productList) {
			if (code.equals(p.getCode())) return p;
		}
		
		return null;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		ProductDTO updateProduct = selectByCode(productDTO.getCode());
		if (updateProduct == null) throw new MyErrorException(ErrorCode.FAILD_UPDATE);
		
		updateProduct.setName(productDTO.getName());
		updateProduct.setPrice(productDTO.getPrice());
		updateProduct.setDetail(productDTO.getDetail());
		
		return 1;
	}

}
