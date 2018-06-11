package j2ee.spring.sellwatches.services;

import java.util.List;

import org.springframework.stereotype.Component;

import j2ee.spring.sellwatches.models.Promotion;

@Component
public interface PromotionService extends MSSQLService<Promotion>{
	public List<Promotion> getList();

	public String getMaxId();
}
