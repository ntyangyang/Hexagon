package com.hexagon.adapter.console;

import com.google.inject.AbstractModule;
import com.hexagon.core.repository.UserRepository;
import com.hexagon.core.service.DefaultUserServiceImpl;
import com.hexagon.core.service.UserService;
import com.hexagon.infrastructure.MemoryUserRepository;

/**
 * @author Eason
 * @createTime 2019-02-18 下午 10:48
 * @description
 */
public class CommandConsoleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRepository.class).to(MemoryUserRepository.class);
        bind(UserService.class).to(DefaultUserServiceImpl.class);
        bind(CommandInterface.class).to(CommandInterfaceImpl.class);
    }
}
