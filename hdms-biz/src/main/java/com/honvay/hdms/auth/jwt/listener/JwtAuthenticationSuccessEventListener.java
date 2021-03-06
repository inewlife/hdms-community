/*   Copyright (c) 2019. 本项目所有源码受中华人民共和国著作权法保护，已登记软件著作权。 *     本项目版权归南昌瀚为云科技有限公司所有，本项目仅供学习交流使用，未经许可不得进行商用，开源（社区版）遵守AGPL-3.0协议。 * */
package com.honvay.hdms.auth.jwt.listener;

import com.honvay.hdms.auth.jwt.store.JwtTokenStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;

/**
 * @author LIQIU
 * created on 2018-11-19
 **/
@Slf4j
public class JwtAuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

	@Autowired
	private JwtTokenStore jwtTokenStore;

	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		jwtTokenStore.save(event.getAuthentication().getName(), event.getAuthentication());
		if (log.isDebugEnabled()) {
			log.debug("Jwt token: [{}] store success", event.getAuthentication().getName());
		}
	}
}
