package com.example.dao;

import java.util.List;
import java.util.Map;

public interface AAAMapper {
	List<Map<String, Object>> select(Map<String, Object> params);
}
