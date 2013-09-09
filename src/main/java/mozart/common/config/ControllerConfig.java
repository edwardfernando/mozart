package mozart.common.config;

import java.lang.reflect.Type;

import mozart.api.service.Service;

import org.springframework.stereotype.Component;

@Component
public class ControllerConfig<T> {
	private Service<T> service;
	private Type type;

	public Service<T> getService() {
		return service;
	}

	public void setService(Service<T> service) {
		this.service = service;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ControllerConfig<T> build(Service<T> service, Type type) {
		this.service = service;
		this.type = type;
		return this;
	}
}
