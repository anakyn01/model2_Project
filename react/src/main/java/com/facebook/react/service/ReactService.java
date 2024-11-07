package com.facebook.react.service;

import java.util.Map;

public interface ReactService {

	int create(Map<String, Object> map);//create

	Map<String, Object> read(int reactContSeq);//read
}
