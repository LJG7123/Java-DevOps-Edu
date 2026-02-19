package ex0219.exam02;

public class Product<K, M> {
	//상품종류
	private K kind;
	
	//상품모델정보
	private M model;
	
	K getKind() {
		return kind;
	}
	void setKind(K kind) {
		this.kind = kind;
	}
	M getModel() {
		return model;
	}
	void setModel(M model) {
		this.model = model;
	}
	
	
}
