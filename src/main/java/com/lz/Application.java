package com.lz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lz.model.Device;
import com.lz.service.IDeviceService;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAsync
@EnableScheduling
@SpringBootApplication
@AllArgsConstructor
@MapperScan("com.lz.mapper")
public class Application {

    private final IDeviceService iDeviceService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @GetMapping("/native/hi")
    public String hiNative() {
        return "i am native application...";
    }

    @GetMapping("/native/device")
    public IPage<Device> devicePageList() {
        Page<Device> page = new Page<>(1, 10);
        LambdaQueryWrapper<Device> wrapper = new LambdaQueryWrapper<Device>().eq(Device::getType, 3);
        return iDeviceService.selectPage(page, wrapper);
    }

    @GetMapping("/native/oneDev")
    public Device oneDev() {
        return iDeviceService.oneDev();
    }

}
