package com.lz.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lz.mapper.DeviceMapper;
import com.lz.model.Device;
import com.lz.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

    @Autowired
    private DeviceMapper deviceMapper;


    @Override
    public IPage<Device> selectPage(IPage<Device> page, Wrapper<Device> queryWrapper) {
        return deviceMapper.selectPage(page, queryWrapper);
    }
}