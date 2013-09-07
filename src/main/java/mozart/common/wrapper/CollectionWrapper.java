package mozart.common.wrapper;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "object-list")
public class CollectionWrapper<T> {

	private List<T> objectList = new ArrayList<T>();

	public List<T> getObjectList() {
		return objectList;
	}

	@XmlElement
	public void setObjectList(List<T> objectList) {
		this.objectList = objectList;
	}

}
