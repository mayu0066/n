package com.example.demo.domain.service.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.domain.mapper.MstDeviceMapper;
import com.example.demo.domain.model.MstDevice;

@Service
public class DeviceDetailService {

	@Autowired
	private MstDeviceMapper mstDeviceMapper; 
	
	@Transactional
	public void update(MstDevice device) {
		mstDeviceMapper.update(device);
	}
}
