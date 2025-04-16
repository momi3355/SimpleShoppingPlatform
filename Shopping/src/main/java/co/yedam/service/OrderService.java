package co.yedam.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
	List<Map<String, Object>> getCarts(int userCode);
}
