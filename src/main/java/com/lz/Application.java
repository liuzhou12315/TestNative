package com.lz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lz.model.Device;
import com.lz.service.IDeviceService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.aop.SpringProxy;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.DecoratingProxy;
import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*@NativeHint(
        options = "--enable-https",
        jdkProxies = @JdkProxyHint(
                types = {
                        IDeviceService.class,
                        IService.class,
                        SpringProxy.class,
                        Advised.class,
                        DecoratingProxy.class
                }
        )
)*/
@RestController
@EnableAsync
@EnableScheduling
@SpringBootApplication
//@ComponentScan(basePackages = {"com.lz"})
@AllArgsConstructor
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


}
