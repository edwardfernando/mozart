package mozart.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
public class CollectionWrapper<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<T> list;

	public CollectionWrapper() {
		list = new ArrayList<T>();
	}

	@XmlAnyElement(lax = true)
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public CollectionWrapper<T> wrap(List<T> list) {
		setList(list);
		return this;
	}
}
