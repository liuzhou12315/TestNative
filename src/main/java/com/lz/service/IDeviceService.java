package com.lz.service;
 
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.model.Device;
import org.apache.ibatis.annotations.Param;

public interface IDeviceService extends IService<Device> {

    IPage<Device> selectPage(IPage<Device> page, @Param(Constants.WRAPPER) Wrapper<Device> queryWrapper);
 
}